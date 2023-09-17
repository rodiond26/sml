package com.github.rodiond26.sml.exception;

import com.github.rodiond26.sml.dto.AppRestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Throwable.class})
    public AppRestResponse<?> createAppRestResponse(Throwable exception) {
        String uuid = UUID.randomUUID().toString();
        String name = exception.getClass().getName();
        String message = exception.getMessage();
        log.error("error: {}, name: {}, message: {}", uuid, name, message);
        return AppRestResponse.fail(new AppRestError(uuid, name, message));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({AppException.class})
    public AppRestResponse<?> catchAppException(AppException exception) {
        String uuid = UUID.randomUUID().toString();
        String name = exception.getErrorType().name();
        String message = exception.getErrorType().getValue();
        log.error("error: {}, name: {}, message: {}", uuid, name, message);
        return AppRestResponse.fail(new AppRestError(uuid, name, message));
    }
}
