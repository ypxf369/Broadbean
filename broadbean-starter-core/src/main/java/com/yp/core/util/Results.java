package com.yp.core.util;

import com.yp.core.base.Result;

/**
 * Result生成工具类
 * Created by yepeng on 2018/11/14.
 */
public class Results {
    protected Results() {
    }

    public static Result newResult() {
        return new Result();
    }

    public static Result newResult(boolean success) {
        return new Result(success);
    }

    // 业务调用成功
    // ---------------------------------------------------------
    public static Result success() {
        return new Result();
    }

    public static Result success(String msg) {
        return new Result(true, null, msg);
    }

    public static Result success(String code, String msg) {
        return new Result(true, code, msg);
    }

    public static Result successWithStatus(Integer status) {
        return new Result(true, status);
    }

    public static Result successWithStatus(Integer status, String msg) {
        return new Result(true, status, null, msg);
    }

    public static Result successWithData(Object data) {
        return new Result(true, null, null, data);
    }

    public static Result successWithData(Object data, String msg) {
        return new Result(true, null, msg, data);
    }

    public static Result successWithData(Object data, String code, String msg) {
        return new Result(true, code, msg, data);
    }

    //业务调用失败
    //-----------------------------------------
    public static Result failure() {
        return new Result(false);
    }

    public static Result failure(String msg) {
        return new Result(false, null, msg);
    }

    public static Result failure(String code, String msg) {
        return new Result(false, code, msg);
    }

    public static Result failureWithStatus(Integer status) {
        return new Result(false, status);
    }

    public static Result failureWithStatus(Integer status, String msg) {
        return new Result(false, status, null, msg);
    }

    public static Result failureWithData(Object data) {
        return new Result(false, null, null, data);
    }

    public static Result failureWithData(Object data, String msg) {
        return new Result(false, null, msg, data);
    }

    public static Result failureWithData(Object data, String code, String msg) {
        return new Result(false, code, msg, data);
    }
}

