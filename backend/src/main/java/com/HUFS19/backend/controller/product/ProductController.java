package com.HUFS19.backend.controller.product;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.enums.SearchConstants;
import com.HUFS19.backend.common.util.AuthCheckUtils;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductPrevDto;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.service.LikeService;
import com.HUFS19.backend.service.ProductService;
import com.HUFS19.backend.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productAPI")
public class ProductController {
    private final ProductService productService;
    private final LikeService likeService;
    private final TagService tagService;

    @GetMapping("/{id}")
    public ApiResponseDto<ProductDetailDto> getProductById(@PathVariable("id") int productId){
        return ResponseUtils.ok(productService.findOne(productId));
    }

    @GetMapping("/user/{userId}")
    public ApiResponseDto<List<ProductDetailDto>> getUserProducts(@PathVariable("userId") String userId){
        return ResponseUtils.ok(productService.getUserProducts(userId));
    }

//    like controller로 이동
//    @GetMapping("/like")
//    public ApiResponseDto addLike() {
//        return ResponseUtils.ok("토큰 검증됨");
//    }

    @GetMapping("/category")
    public ApiResponseDto<List<ProductPrevDto>> getCategoryProducts(@RequestParam int categoryId){
        List<ProductPrevDto> productPrevDtos=productService.getCategoryProducts(categoryId);
        productPrevDtos.forEach(v->v.setLike(likeService.getLikeAmount(v.getId())));
        if (AuthCheckUtils.getLoginStatus()){
            productPrevDtos.forEach(v->v.setLikeStatus(
                    likeService.checkProductLikeStatus(
                            v.getId(), AuthCheckUtils.getLoginUserId()
                    )
            ));
        }
        return ResponseUtils.ok(productPrevDtos);
    }

    @GetMapping("/search")
    public ApiResponseDto<List<ProductPrevDto>> searchProducts(
            @RequestParam(name="categoryId")int categoryId,
            @RequestParam(name="type")String searchOption,
            @RequestParam(name="search")String keyword ){
        List<ProductPrevDto> productPrevDtos;

        if(searchOption.equals(SearchConstants.SEARCH_TAG.getMessage())){
            productPrevDtos = productService.searchProducts(categoryId, searchOption, keyword);
        } else{
            productPrevDtos = tagService.searchProducts(keyword, categoryId);
        }
        productPrevDtos.forEach(v->v.setLike(likeService.getLikeAmount(v.getId())));
        if (AuthCheckUtils.getLoginStatus()){
            productPrevDtos.forEach(v->v.setLikeStatus(
                    likeService.checkProductLikeStatus(
                            v.getId(), AuthCheckUtils.getLoginUserId()
                    )
            ));
        }
        return ResponseUtils.ok(productPrevDtos);
    }



}
