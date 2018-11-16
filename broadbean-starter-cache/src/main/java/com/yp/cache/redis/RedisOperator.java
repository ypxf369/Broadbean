package com.yp.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Redis 操作工具
 * Created by yepeng on 2018/11/16.
 */
@Component
public class RedisOperator {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperation;
    @Autowired
    private HashOperations<String, String, Object> hashOperation;
    @Autowired
    private ListOperations<String, Object> listOperation;
    @Autowired
    private SetOperations<String, Object> setOperation;
    @Autowired
    private ZSetOperations<String, Object> zSetOperation;

    /**
     * 默认过期时长，单位:秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * Redis的根操作路径
     */
    @Value("${redis.root:broadbean}")
    private String category;

    public RedisOperator setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * 获取Key的全路径
     *
     * @param key
     * @return full key
     */
    public String getFullKey(String key) {
        return this.category + ":" + key;
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public ValueOperations<String, String> getValueOperation() {
        return valueOperation;
    }

    public HashOperations<String, String, Object> getHashOperation() {
        return hashOperation;
    }

    public ListOperations<String, Object> getListOperation() {
        return listOperation;
    }

    public SetOperations<String, Object> getSetOperation() {
        return setOperation;
    }

    public ZSetOperations<String, Object> getzSetOperation() {
        return zSetOperation;
    }

    //
    // key
    // -------------------------------------------

    /**
     * 判断key是否存在
     */
    public boolean existsKey(String key) {
        return redisTemplate.hasKey(getFullKey(key));
    }

    /**
     * 判断key存储的值的类型
     *
     * @return DataType[string、list、set、zset、hash]
     */
    public DataType typeKey(String key) {
        return redisTemplate.type(getFullKey(key));
    }

    /**
     * 重命名key。如果newKey已经存在，则newKey的原值被覆盖
     */
    public void renameKey(String oldKey, String newKey) {
        redisTemplate.rename(getFullKey(oldKey), getFullKey(newKey));
    }

    /**
     * newKey不存在时才重命名
     *
     * @param oldKey
     * @param newKey
     * @return 修改成功返回true
     */
    public boolean renameKeyIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 删除key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     */
    public void deleteKey(String... keys) {
        Set<String> ks = Stream.of(keys).map(k -> getFullKey(k)).collect(Collectors.toSet());
        redisTemplate.delete(ks);
    }

    /**
     * 批量删除key
     */
    public void deleteKey(Collection<String> keys) {
        Set<String> ks = keys.stream().map(k -> getFullKey(k)).collect(Collectors.toSet());
        redisTemplate.delete(ks);
    }

    /**
     * 设置key的生命周期，单位秒
     *
     * @param key
     * @param time     时间数
     * @param timeUnit TimeUnit 时间单位
     */
    public void expireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 设置key在指定的日期过期
     *
     * @param key
     * @param date 指定日期
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    /**
     * 查询key的生命周期
     *
     * @param key
     * @param timeUnit TimeUnit 时间单位
     * @return 指定时间单位的时间数
     */
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 将key设置为永久有限
     */
    public void persistKey(String key) {
        redisTemplate.persist(key);
    }


}
