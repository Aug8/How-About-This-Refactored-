package com.HUFS19.backend.message;

import com.HUFS19.backend.category.CategoryRepository;
import com.HUFS19.backend.category.CategoryRepositoryImp;
import com.HUFS19.backend.chatRoom.ChatRoom;
import com.HUFS19.backend.chatRoom.ChatRoomRepository;
import com.HUFS19.backend.chatRoom.ChatRoomRepositoryImp;
import com.HUFS19.backend.product.ProductRepository;
import com.HUFS19.backend.product.ProductRepositoryImp;
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
@Import({MessageRepositoryImp.class, CategoryRepositoryImp.class, ProductRepositoryImp.class, UserRepositoryImp.class, ChatRoomRepositoryImp.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class MessageRepositoryImpTest {
    @Autowired
    TestEntityManager testEM;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Test
    void 저장_조회() {
        Message message = new Message();
        message.setCategory(categoryRepository.findById(1).get());
        message.setProduct(productRepository.findById(1).get());
        message.setUser(userRepository.findById("testID").get());
        message.setSender(userRepository.findById("testID").get());
        message.setInquirer(userRepository.findById("user4444").get());
        message.setChatRoom(chatRoomRepository.findById(1).get());
        message.setContent("메세지입니다.");

        int id = messageRepository.save(message);
        Message saved = messageRepository.findById(id).get();

        assertEquals(message, saved);
    }
}