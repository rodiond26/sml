package com.github.rodiond26.sml.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AppException extends RuntimeException {

    private final ErrorType errorType;
    private final HttpStatus httpStatus;
    private String errorText;

    public AppException(ErrorType errorType ) {
        this.errorType = errorType;
        this.httpStatus = HttpStatus.OK;
        this.errorText = "";
    }
}
