package com.yidai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yidai
 * HTTP状态码
 * 自定义NotFoundException异常,会跳转到404页面
 */
@ResponseStatus(HttpStatus.NOT_FOUND)      //
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
