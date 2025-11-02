package com.lcf.db.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BaseException extends RuntimeException {

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
