package com.HUFS19.backend.userInfo;

import com.HUFS19.backend.user.User;
import com.HUFS19.backend.user.UserRepository;
import com.HUFS19.backend.user.UserRepositoryImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({UserInfoRepositoryImp.class, UserRepositoryImp.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserInfoRepositoryImpTest {

    @Autowired
    TestEntityManager testEM;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void save() {
        User newUser = new User();
        newUser.setId("testUser");
        newUser.setSalt("");
        newUser.setPassword("testPw");
        String userId = userRepository.save(newUser);

        UserInfo saved = userInfoRepository.findByUserId("testUser").get();

        assertEquals(newUser, saved.getUser());
        assertEquals(newUser.getId(), saved.getNickname());
    }
}