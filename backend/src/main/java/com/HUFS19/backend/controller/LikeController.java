package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.AuthCheckUtils;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likeAPI")
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/product")
    public ApiResponseDto<List<ProductDetailDto>> getLikedProducts(){
        return ResponseUtils.ok(likeService.getLikedProducts(AuthCheckUtils.getLoginUserId()));
    }

    @GetMapping("/{productId}/likeCheck")
    public ApiResponseDto<Boolean> checkProductLike(@PathVariable("productId") int productId){
        return ResponseUtils.ok(likeService.checkProductLikeStatus(productId, AuthCheckUtils.getLoginUserId()));
    }



}
