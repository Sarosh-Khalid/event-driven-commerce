package com.techvista.userservice.exception;


import com.techvista.userservice.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleRuntime(
            RuntimeException ex) {


        return new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );
    }


}