package com.yp.starter.core.base;

import org.springframework.aop.framework.AopContext;

/**
 * 获取代理对象本身
 * Created by yepeng on 2018/11/15.
 */
public interface ProxySelf<T> {
    /**
     * 获取当前对象的代理。
     *
     * @return 代理对象，如果未被代理，则抛出 IllegalStateException
     */
    @SuppressWarnings("unchecked")
    default T self() {
        return (T) AopContext.currentProxy();
    }
}
