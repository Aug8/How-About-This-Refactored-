package com.HUFS19.backend.service;

import com.HUFS19.backend.common.enums.SearchConstants;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductPrevDto;
import com.HUFS19.backend.error.CustumException;
import com.HUFS19.backend.error.ErrorCode;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.tag.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final TagRepository tagRepository;

    public int addProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public ProductDetailDto findOne(int productId) {
        return productRepository.findById(productId).orElseThrow(()->new CustumException(ErrorCode.MISSING_PRODUCT));
    }

    public List<Product> findAll() {
        return productRepository.findAll(1);
    }

    public List<ProductDetailDto> getUserProducts(String userId) {
        return productRepository.findByUserId(userId);
    }

    public List<ProductPrevDto> searchProducts(int categoryId, String searchOption, String keyword){
            return productRepository.searchProduct(keyword, searchOption, categoryId);
    }
    public List<ProductPrevDto> getCategoryProducts(int categoryId){
        return productRepository.findCategoryProducts(categoryId);
    }



}
