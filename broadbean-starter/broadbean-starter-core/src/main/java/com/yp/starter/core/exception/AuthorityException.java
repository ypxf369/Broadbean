package com.yp.starter.core.exception;

/**
 * Created by yepeng on 2018/11/15.
 */
public class AuthorityException extends BaseException {
    private static final long serialVersionUID = 8521546987563214896L;

    public AuthorityException() {
    }

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(String code, String message) {
        super(code, message);
    }
}
