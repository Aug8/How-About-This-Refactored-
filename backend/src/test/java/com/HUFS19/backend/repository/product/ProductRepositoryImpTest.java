package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.category.CategoryRepository;
import com.HUFS19.backend.repository.category.CategoryRepositoryImp;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.product.ProductRepositoryImp;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
@Import({ProductRepositoryImp.class, UserRepositoryImp.class, CategoryRepositoryImp.class})
class ProductRepositoryImpTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;

    //id, date 확인 필요
    @Test
    public void 상품_저장_확인(){
        Product product = Product.builder()
                .user(User.builder().id("testId").password("testPw").build())
                .link("http://www.com")
                .detail("상세설명")
                .name("상품 이름")
                .category(Category.builder().name("카테고리").build())
                .mainImg("/img/001.jpg")
                .build();

        int productId = productRepository.save(product);
        ProductDetailDto foundProductDto = productRepository.findById(productId).orElseThrow(RuntimeException::new);

        assertEquals(product.getName(), foundProductDto.getName());
        assertEquals(product.getLink(), foundProductDto.getLink());
        assertEquals(product.getDetail(), foundProductDto.getDetail());
        assertEquals(product.getCategory().getName(), foundProductDto.getCategoryName());
        assertEquals(product.getMainImg(), foundProductDto.getMainImg());
        assertEquals(product.getName(), foundProductDto.getName());
    }

}