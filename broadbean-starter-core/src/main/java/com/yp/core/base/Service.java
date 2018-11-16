package com.yp.core.base;

import java.util.List;

/**
 * Service 基础通用接口
 * Created by yepeng on 2018/11/15.
 */
public interface Service<T> {

    //
    // insert
    // ----------------------------------------------------------------------------------------------------

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     */
    T insert(T record);

    /**
     * 批量插入，null的属性也会保存，不会使用数据库默认值
     *
     * @param recordList
     * @return
     */
    List<T> insert(List<T> recordList);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     */
    T insertSelective(T record);

    /**
     * 批量插入，null的属性不会保存，会使用数据库默认值
     *
     * @param recordList
     * @return
     */
    List<T> insertSelective(List<T> recordList);

    //
    // update
    // ----------------------------------------------------------------------------------------------------

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @return
     */
    T update(T record);

    /**
     * 批量更新，根据主键更新实体全部字段，null值会被更新
     *
     * @param recordList
     * @return
     */
    List<T> update(List<T> recordList);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    T updateSelective(T record);

    /**
     * 批量更新，根据主键更新属性不为null的值
     *
     * @param recordList
     * @return
     */
    List<T> updateSelective(List<T> recordList);

    //
    // delete
    // ----------------------------------------------------------------------------------------------------

    /**
     * 根据主键删除
     *
     * @param id id不能为空
     * @return
     */
    int delete(Long id);

    /**
     * 根据主键删除多个实体，ID数组
     *
     * @param ids 类似[1,2,3]，不能为空
     */
    int delete(Long[] ids);

    /**
     * 根据实体属性作为条件进行删除
     *
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 根据主键删除多个实体
     *
     * @param recordList
     * @return
     */
    int delete(List<T> recordList);

    //
    // insert or update or delete
    // ----------------------------------------------------------------------------------------------------

    /**
     * 根据实体的operate决定哪种操作. null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     */
    T persist(T record);

    /**
     * 批量操作.根据实体的operate决定哪种操作. null的属性也会保存，不会使用数据库默认值
     *
     * @param recordList
     * @return
     */
    List<T> persist(List<T> recordList);

    /**
     * 根据实体的operate决定哪种操作. 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    T persistSelective(T record);

    /**
     * 批量操作.根据实体的operate决定哪种操作. 根据主键更新属性不为null的值
     *
     * @param recordList
     * @return
     */
    List<T> persistSelective(List<T> recordList);


    //
    // select
    // ----------------------------------------------------------------------------------------------------

    /**
     * 根据主键查询
     *
     * @param id 不能为空
     * @return
     */
    T get(Long id);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常
     *
     * @param record
     * @return
     */
    T get(T record);

    /**
     * 根据字段和值查询 返回一个
     *
     * @param key   不能为空
     * @param value 不能为空
     * @return
     */
    T get(String key, Object value);


    /**
     * 根据主键字符串进行查询
     *
     * @param ids 如 "1,2,3,4"
     * @return
     */
    List<T> select(String ids);

    /**
     * 根据实体中的属性值进行查询
     *
     * @param record
     * @return
     */
    List<T> select(T record);

    /**
     * 根据属性和值查询
     *
     * @param key
     * @param value
     * @return
     */
    List<T> select(String key, Object value);

    /**
     * 根据实体中的属性值进行分页查询
     *
     * @param record
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<T> select(T record, int pageIndex, int pageSize);

    /**
     * 查询全部结果
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性查询总数
     *
     * @param record
     * @return
     */
    int count(T record);
}
