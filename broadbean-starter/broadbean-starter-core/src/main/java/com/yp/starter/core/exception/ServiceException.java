package com.yp.starter.core.exception;

/**
 * Service层异常
 * Created by yepeng on 2018/11/14.
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = 6058294324031642376L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }
}
