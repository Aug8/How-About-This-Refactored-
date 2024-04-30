package com.HUFS19.backend.repository.tag;

import com.HUFS19.backend.dto.product.ProductPrevDto;
import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.product.ProductRepositoryImp;
import com.HUFS19.backend.repository.tag.Tag;
import com.HUFS19.backend.repository.tag.TagRepository;
import com.HUFS19.backend.repository.tag.TagRepositoryImp;
import com.HUFS19.backend.repository.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({TagRepositoryImp.class, ProductRepositoryImp.class})
@TestPropertySource(locations = "classpath:application.properties")
class TagRepositoryImpTest {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    ProductRepository productRepository;

    private int num=0;

    void plusNum(){
        num+=1;
    }

    User createUserObj(){
        return User.builder().salt("").id(String.format("testUser%d", num)).password(String.format("testPw%d", num)).build();
    }
    Category createCategory(){
        return Category.builder().name(String.format("testCategory%d", num)).build();
    }
    Product createProduct(){
        return Product.builder().user(createUserObj()).link(String.format("test%d", num))
                .detail(String.format("test%d", num))
                .mainImg(String.format("test%d", num))
                .category(createCategory())
                .name(String.format("test%d", num))
                .build();
    }
    Tag createTag(){
        plusNum();
        return Tag.builder().product(createProduct()).name(String.format("TaG%d", num)).build();
    }
    @BeforeEach
    void saveTags(){
        tagRepository.save(createTag());
        tagRepository.save(createTag());
        tagRepository.save(createTag());
        tagRepository.save(createTag());
    }
    @Test
    @DisplayName("태그 조회")
    void save() {
        Tag saved = tagRepository.findById(1).orElseThrow(RuntimeException::new);
        assertEquals(saved.getId(), 1);
    }

    @Test@DisplayName("태그로 상품 검색")
    void searchProductByTag(){
//        given
//        when
        List<ProductPrevDto> prevDtos1 = tagRepository.findByPartialTag("tag", 0);
        List<ProductPrevDto> prevDtos2 = tagRepository.findByPartialTag("tag", 1);
        List<ProductPrevDto> prevDtos3 = tagRepository.findByPartialTag("2", 0);
//        then
        assertEquals(prevDtos1.size(), 4);
        assertEquals(prevDtos2.size(), 1);
        assertEquals(prevDtos3.size(), 1);
    }
}