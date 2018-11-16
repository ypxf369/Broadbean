package com.yp.core.base;

/**
 * 基础枚举接口
 * Created by yepeng on 2018/11/14.
 */
public interface BaseEnum<K, V> {
    /**
     * 获取编码
     *
     * @return 编码
     */
    K code();

    /**
     * 获取描述
     *
     * @return 描述
     */
    V desc();
}
