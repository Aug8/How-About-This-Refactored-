package com.HUFS19.backend.repository.comment;

import com.HUFS19.backend.repository.comment.Comment;
import com.HUFS19.backend.repository.comment.CommentRepository;
import com.HUFS19.backend.repository.comment.CommentRepositoryImp;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.product.ProductRepositoryImp;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({CommentRepositoryImp.class, ProductRepositoryImp.class, UserRepositoryImp.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommentRepositoryImpTest {
    @Autowired
    TestEntityManager testEM;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
//
//    @Test
//    void 저장_조회() {
//        Comment comment = new Comment();
//        comment.setProduct(productRepository.findById(1).get());
//        comment.setUser(userRepository.findById("testID").get());
//        comment.setContent("상품에 대한 코멘트");
//
//        int id = commentRepository.save(comment);
//        Comment saved = commentRepository.findByID(id).get();
//
//        assertEquals(comment, saved);
//    }
}