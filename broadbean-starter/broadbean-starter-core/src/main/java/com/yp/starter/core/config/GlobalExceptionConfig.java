package com.yp.starter.core.config;

import com.yp.starter.core.base.Result;
import com.yp.starter.core.constants.BaseEnums;
import com.yp.starter.core.util.Results;
import com.yp.starter.core.exception.AuthorityException;
import com.yp.starter.core.exception.BaseException;
import com.yp.starter.core.exception.NoHandlerFoundException;
import com.yp.starter.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * Created by yepeng on 2018/11/15.
 */
@RestControllerAdvice
public class GlobalExceptionConfig {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionConfig.class);

    /**
     * 处理 ServiceException 异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.BAD_REQUEST.value());
        logger.info("ServiceException[code: {}, messsage: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 AuthorityException 异常
     */
    @ExceptionHandler(AuthorityException.class)
    public Result handleAuthorityException(AuthorityException e) {
        Result result = Results.failure(BaseEnums.FORBIDDEN.code(), BaseEnums.FORBIDDEN.desc());
        result.setStatus(HttpStatus.FORBIDDEN.value());
        logger.info("AuthorityException[code: {}, message: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 NoHandlerFoundException 异常
     * 需配置 [spring.mvc.throw-exception-fi-no-handler-found=true]
     * 需配置 [spring.resources.add-mappings=false]
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleNotFoundExcrption(NoHandlerFoundException e) {
        Result result = Results.failure(BaseEnums.NOT_FOUND.code(), BaseEnums.NOT_FOUND.desc());
        result.setStatus(HttpStatus.NOT_FOUND.value());
        logger.info(e.getMessage());
        return result;
    }


    /**
     * 处理 BaseException 异常
     */
    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException e) {
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error("BaseException[code: {}, message: {}]", e.getCode(), e.getMessage(), e);
        return result;
    }

    /**
     * 处理 Exception 异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        Result result = Results.failure(BaseEnums.ERROR.code(), BaseEnums.ERROR.desc());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error(e.getMessage(), e);
        return result;
    }

}
