package com.gthsoftware.casino.configuration;

import com.gthsoftware.casino.response.APIResponse;
import com.gthsoftware.casino.utils.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleCustomException(Exception ex) {
        APIResponse<String> apiResponse = APIResponse.<String>builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(Constant.RESULT_KO)
                .message(ex.getMessage())
                .internalCode(Constant.GERNERIC_RESPOONSE_CODE)
                .data(null)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
