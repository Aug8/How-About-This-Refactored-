package com.HUFS19.backend.repository.user;

import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({UserRepositoryImp.class})
@TestPropertySource(locations = "classpath:application.properties")
class UserRepositoryImpTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 엔티티 저장, 조회")
    void save() {
        User user = User.builder().id("testUser").password("testpw").salt("temp").build();
        String id = userRepository.save(user);
        User saved = userRepository.findById(id).orElseThrow(RuntimeException::new);

        assertEquals(user, saved);
    }

}