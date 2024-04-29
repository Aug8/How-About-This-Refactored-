package com.HUFS19.backend.repository.userLike;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({UserLikeRepositoryImp.class})
@TestPropertySource(locations = "classpath:application.properties")
class UserLikeRepositoryImpTest {

    @Autowired
    UserLikeRepository userLikeRepository;

    private int num=0;

    void plusNum(){
        num+=1;
    }
    UserLike createUserLikeObj(User user, Product product){
        return UserLike.builder().user(user).product(product).category(product.getCategory()).build();
    }
    User createUserObj(){
        plusNum();
        return User.builder().salt("").id(String.format("testUser%d", num)).password(String.format("testPw%d", num)).build();
    }
    Category createCategory(){
        plusNum();
        return Category.builder().name(String.format("testCategory%d", num)).build();
    }
    Product createProduct(){
        plusNum();
        Product product = Product.builder().user(createUserObj()).link(String.format("test%d", num))
                .detail(String.format("test%d", num))
                .mainImg(String.format("test%d", num))
                .category(createCategory())
                .name(String.format("test%d", num))
                .build();
        return product;
    }

    @Test
    @DisplayName("특정 유저의 좋아요 상품 목록 조회")
    void getLikedProduct() {
        //given
        User user = createUserObj();
        Product product1 = createProduct();
        Product product2 = createProduct();
        UserLike userLike1 = createUserLikeObj(user, product1);
        UserLike userLike2 = createUserLikeObj(user, product2);

        userLikeRepository.save(userLike1);
        userLikeRepository.save(userLike2);

        //when
        List<ProductDetailDto> foundUserLikeList = userLikeRepository.getLikedProduct(user.getId());

        //then
        assertEquals(foundUserLikeList.size(), 2);


    }

    @Test
    @DisplayName("특정 유저, 상품의 좋아요 유무 확인")
    void getProductLikeStatus() {
//        given
        User user = createUserObj();
        Product likeProduct = createProduct();
        Product nonLikeProduct = createProduct();
        UserLike userLike = createUserLikeObj(user, likeProduct);

        userLikeRepository.save(userLike);

//        when
        Optional<UserLike> foundUserLike = userLikeRepository.getProductLikeStatus(likeProduct.getId(), user.getId());
        Optional<UserLike> nullUserLike = userLikeRepository.getProductLikeStatus(nonLikeProduct.getId(), user.getId());

//        then
        assertTrue(foundUserLike.isPresent());
        assertTrue(nullUserLike.isEmpty());
    }
}