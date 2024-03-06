package com.HUFS19.backend.common.util;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.dto.ErrorResponse;
import com.HUFS19.backend.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class ResponseUtils {
    public static <T> ApiResponseDto<T> ok(T response){
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setData(response);
        apiResponseDto.setSuccess(true);
        return apiResponseDto;
    }

    public static <T> ApiResponseDto<T> error(HttpStatus status, int code,  String message){
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setSuccess(false);
        apiResponseDto.setError(new ErrorResponse(status, code, message));
        return apiResponseDto;
    }
}