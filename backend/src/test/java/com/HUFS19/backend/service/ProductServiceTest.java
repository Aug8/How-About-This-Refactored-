//package com.HUFS19.backend.service;
//
//import com.HUFS19.backend.repository.category.Category;
//import com.HUFS19.backend.repository.category.CategoryRepository;
//import com.HUFS19.backend.repository.product.Product;
//import com.HUFS19.backend.repository.product.ProductRepository;
//import com.HUFS19.backend.repository.user.UserRepository;
//import com.HUFS19.backend.service.ProductService;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class ProductServiceTest {
//    @Autowired
//    ProductService productService;
//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Test
//    void 상품_추가_조회(){
//        Product product = new Product();
//        product.setCategory(categoryRepository.findById(1).get());
//        product.setDetail("상품설명");
//        product.setLink("www");
//        product.setMainImg("/main");
//        product.setUser(userRepository.findById("user4444").get());
//        product.setName("상품명");
//
//        productService.addProduct(product);
//
//        assertEquals(product.getId(), productService.findOne(product.getId()).getId());
//    }
//
//    @Test
//    void 전체_조회(){
//        int productAmount = 8;
//        assertEquals(productService.findAll().size(), productAmount);
//    }
//
//    @Test
//    void 유저_아이디로_상품_조회(){
//        String existtUser = "user4444";
//        String nonExistUser = "asefds23";
//
//        assertEquals(productService.getUserProducts(existtUser).size(), 4);
//        assertEquals(productService.getUserProducts(nonExistUser).size(), 0);
//    }
//
//}