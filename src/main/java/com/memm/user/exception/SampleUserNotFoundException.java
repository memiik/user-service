package com.memm.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SampleUserNotFoundException extends RuntimeException {
    public SampleUserNotFoundException(String message) {
        super(message);
    }
}
