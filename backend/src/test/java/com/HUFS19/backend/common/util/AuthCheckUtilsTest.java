package com.HUFS19.backend.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthCheckUtilsTest {

    @Test
    @DisplayName("로그인한 사용자 확인")
    void getLoginUserId() {
        assertEquals(AuthCheckUtils.getLoginUserId(), "");
    }

    @Test
    @DisplayName("로그인 여부 확인")
    void getLoginStatus(){
        assertFalse(AuthCheckUtils.getLoginStatus());
    }
}