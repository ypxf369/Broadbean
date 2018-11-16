package com.yp.core.constants;

import org.apache.commons.io.Charsets;

import java.nio.charset.Charset;

/**
 * 系统级常量类
 * Created by yepeng on 2018/11/14.
 */
public class Constants {
    public static final String APP_NAME = "broadbean";

    /**
     * 系统编码
     */
    public static final Charset CHARSET = Charsets.UTF_8;

    /**
     * 标识:是/否、启用/禁用等
     */
    public interface Flag {
        Integer YES = 1;
        Integer NO = 0;
    }

    /**
     * 操作类型
     */
    public interface Operation {
        String ADD = "add";
        String UPDATE = "update";
        String DELETE = "delete";
    }

    /**
     * 性别
     */
    public interface Gender {
        /**
         * 男
         */
        Integer MALE = 1;

        /**
         * 女
         */
        Integer FEMALE = 0;
    }
}
