package com.HUFS19.backend.service;

import com.HUFS19.backend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void check_id_redundent_case_true() {
        boolean result = userService.checkIdDuplication("testID");
        Assertions.assertEquals(result, true);
    }
    @Test
    void check_id_redundent_case_false() {
        boolean result = userService.checkIdDuplication("new");
        Assertions.assertEquals(result, false);
    }

}