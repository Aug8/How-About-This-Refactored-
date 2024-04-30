package com.HUFS19.backend.error;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    public ApiResponseDto handleUserConflict(CustumException e){
        log.warn("handleUserConflict", e);
        System.out.println("errorHandler excute!");
        return makeResponse(e.getErrorCode());

    }
    @ExceptionHandler
    public ApiResponseDto handleAllException(Exception e){
        log.warn("handleAllException", e);
        return makeResponse(ErrorCode.INTER_SERVER_EROR);
    }

    private ApiResponseDto makeResponse(ErrorCode errorCode){
        return ResponseUtils.error(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage());
    }
}
