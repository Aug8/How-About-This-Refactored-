package com.HUFS19.backend.userInfo;

import com.HUFS19.backend.dto.profile.ProfileDto;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import com.HUFS19.backend.repository.userInfo.UserInfoRepository;
import com.HUFS19.backend.repository.userInfo.UserInfoRepositoryImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        ProfileDto saved = userInfoRepository.findByUserId("testUser").get();

        assertEquals(newUser.getId(), saved.getUserId());
        assertEquals(newUser.getId(), saved.getNickname());
    }
}