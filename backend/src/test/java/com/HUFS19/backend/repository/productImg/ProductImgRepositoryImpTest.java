//package com.HUFS19.backend.repository.productImg;
//
//import com.HUFS19.backend.repository.product.ProductRepository;
//import com.HUFS19.backend.repository.product.ProductRepositoryImp;
//import com.HUFS19.backend.repository.productImg.ProductImg;
//import com.HUFS19.backend.repository.productImg.ProductImgRepository;
//import com.HUFS19.backend.repository.productImg.ProductImgRepositoryImp;
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
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import({ProductImgRepositoryImp.class, ProductRepositoryImp.class})
//class ProductImgRepositoryImpTest {
//    @Autowired
//    TestEntityManager testEM;
//    @Autowired
//    ProductImgRepository productImgRepository;
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    void save() {
//        ProductImg productImg = new ProductImg();
//
//        productImg.setProduct(productRepository.findById(1).get());
//        productImg.setOrder(5);
//        productImg.setImg("/img/001.jpg");
//
//        int productImgId = productImgRepository.save(productImg);
//        ProductImg foundProductImg = productImgRepository.findById(productImgId).get();
//
//        assertEquals(productImg.getOrder(), foundProductImg.getOrder());
//        assertEquals(productImg.getImg(), foundProductImg.getImg());
//    }
//}