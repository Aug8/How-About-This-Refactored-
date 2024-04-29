//package com.HUFS19.backend.repository.tag;
//
//import com.HUFS19.backend.repository.product.ProductRepository;
//import com.HUFS19.backend.repository.product.ProductRepositoryImp;
//import com.HUFS19.backend.repository.tag.Tag;
//import com.HUFS19.backend.repository.tag.TagRepository;
//import com.HUFS19.backend.repository.tag.TagRepositoryImp;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.Import;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@Import({TagRepositoryImp.class, ProductRepositoryImp.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class TagRepositoryImpTest {
//    @Autowired
//    TestEntityManager testEM;
//    @Autowired
//    TagRepository tagRepository;
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    void save() {
//        Tag tag = new Tag();
//        tag.setName("태그");
//        tag.setProduct(productRepository.findById(1).get());
//
//        int id = tagRepository.save(tag);
//        Tag saved = tagRepository.findById(id).get();
//
//        assertEquals(tag, saved);
//    }
//}