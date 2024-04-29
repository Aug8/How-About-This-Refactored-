package com.HUFS19.backend.service;

import com.HUFS19.backend.common.util.AuthCheckUtils;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.repository.userLike.UserLikeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final UserLikeRepository userLikeRepository;

    public List<ProductDetailDto> getLikedProducts(String loginUserId){
        return userLikeRepository.getLikedProduct(loginUserId);
    }

    public boolean checkProductLikeStatus(int productId, String loginUserId){
        return userLikeRepository.getProductLikeStatus(productId, loginUserId).isPresent();
    }
}
