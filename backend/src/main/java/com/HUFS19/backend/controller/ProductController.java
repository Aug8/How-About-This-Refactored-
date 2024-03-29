package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.service.ProductService;
import com.HUFS19.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("/productAPI")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService, TagService tagService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ApiResponseDto<ProductDetailDto> getProductById(@PathVariable("id") int productId){
        return ResponseUtils.ok(productService.findOne(productId));
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    public ApiResponseDto<List<ProductDetailDto>> getUserProducts(@PathVariable("userId") String userId){
        return ResponseUtils.ok(productService.getUserProducts(userId));
    }

    @GetMapping("/like")
    @ResponseBody
    public ApiResponseDto addLike() {
        return ResponseUtils.ok("토큰 검증됨");
    }

//    @GetMapping("/productAPI/list")
//    @ResponseBody
//    public CategoryproductsResponse getCategoryProducts(@RequestParam int category, @RequestParam String sort){
//        CategoryproductsResponse categoryproductsResponse = new CategoryproductsResponse();
//        categoryproductsResponse.setProductSummaries(productService.getCategoryProducts(category, sort));
//        return categoryproductsResponse;
//    }




}
