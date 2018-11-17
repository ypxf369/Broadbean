package com.yp.starter.core.exception;

/**
 * Created by yepeng on 2018/11/15.
 */
public class NoHandlerFoundException extends BaseException {
    private static final long serialVersionUID = -4545126879542358971L;

    public NoHandlerFoundException() {
    }

    public NoHandlerFoundException(String message) {
        super(message);
    }

    public NoHandlerFoundException(String code, String message) {
        super(code, message);
    }
}
