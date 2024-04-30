package com.HUFS19.backend.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustumException extends RuntimeException{
    private final ErrorCode errorCode;
}
