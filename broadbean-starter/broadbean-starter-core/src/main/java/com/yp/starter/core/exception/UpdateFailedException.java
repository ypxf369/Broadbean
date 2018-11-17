package com.yp.starter.core.exception;

/**
 * Created by yepeng on 2018/11/15.
 */
public class UpdateFailedException extends BaseException {
    private static final long serialVersionUID = 4565124879654123659L;

    public UpdateFailedException() {
    }

    public UpdateFailedException(String message) {
        super(message);
    }

    public UpdateFailedException(String code, String message) {
        super(code, message);
    }
}
