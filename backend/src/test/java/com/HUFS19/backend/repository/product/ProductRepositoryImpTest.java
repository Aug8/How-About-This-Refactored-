package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.common.enums.SearchConstants;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductPrevDto;
import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.category.CategoryRepository;
import com.HUFS19.backend.repository.category.CategoryRepositoryImp;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.product.ProductRepositoryImp;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
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

    private int num=0;

    void plusNum(){num += 1;}

    User createUserObj(){

        User user= User.builder().salt("").id(String.format("testUser%d", num)).password(String.format("testPw%d", num)).build();
        System.out.println(user.getId());
        return user;
    }
    Category createCategory(){

        return Category.builder().name(String.format("testCategory%d", num)).build();
    }
    Product createProduct(){
        plusNum();
        return Product.builder().user(createUserObj()).link(String.format("test%d", num))
                .detail(String.format("test%d", num))
                .mainImg(String.format("test%d", num))
                .category(createCategory())
                .name(String.format("test%d", num))
                .build();
    }

    @BeforeEach
    void saveProducts(){
        productRepository.save(createProduct());
        productRepository.save(createProduct());
        productRepository.save(createProduct());
    }

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

    @Test
    @DisplayName("상품 검색-업로더 옵션")
    void searchProduct(){
//        given
//        when
        List<ProductPrevDto> prevDtoList = productRepository.searchProduct(
                "user",
                SearchConstants.SEARCH_UPLOADER.getMessage(),
                0);

        List<ProductPrevDto> prevDtoList1 = productRepository.searchProduct(
                "1",
                SearchConstants.SEARCH_UPLOADER.getMessage(),
                0);

//        then
        assertEquals(prevDtoList.size(), 3);
        assertEquals(prevDtoList1.size(), 1);
    }

    @Test
    @DisplayName("상품 검색-상품 옵션")
    void searchProductOption(){
//        given
//        when
        List<ProductPrevDto> prevDtoList = productRepository.searchProduct(
                "te",
                SearchConstants.SEARCH_PRODUCT.getMessage(),
                0);

        List<ProductPrevDto> prevDtoList2 = productRepository.searchProduct(
                "te",
                SearchConstants.SEARCH_PRODUCT.getMessage(),
                1);

        List<ProductPrevDto> prevDtoList3 = productRepository.searchProduct(
                "2",
                SearchConstants.SEARCH_PRODUCT.getMessage(),
                0);
//then
        assertEquals(prevDtoList.size(), 3);
        assertEquals(prevDtoList2.size(), 1);
        assertEquals(prevDtoList3.size(), 1);
    }

    @Test
    @DisplayName("카테고리 상품 조회")
    void getCategoryProducts(){
//        given
//        when
        List<ProductPrevDto> prevDtos1 = productRepository.findCategoryProducts(0);
        List<ProductPrevDto> prevDtos2 = productRepository.findCategoryProducts(1);

//        then
        assertEquals(prevDtos1.size(), 3);
        assertEquals(prevDtos2.size(), 1);
    }
}