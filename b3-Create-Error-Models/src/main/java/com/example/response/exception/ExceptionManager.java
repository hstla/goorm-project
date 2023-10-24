package com.example.response.exception;

import com.example.response.form.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler
    public ApiResponse StudentExceptionHandler(CustomException e) {
        return new ApiResponse(e.getErrorCode().getCode(),
            e.getMessage(),
            e.getData()
        );
    }
}
