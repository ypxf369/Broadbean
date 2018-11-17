package com.yp.starter.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yepeng on 2018/11/14.
 */
@Configuration
//@EnableAspectJAutoProxy(exposeProxy = true)//暴露代理对象，否则AopContext.currentProxy()会抛出异常
@PropertySource(value = "classpath:application.properties")
public class BroadbeanCoreConfig {
}
