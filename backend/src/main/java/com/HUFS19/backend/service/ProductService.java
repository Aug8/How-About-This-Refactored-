package com.HUFS19.backend.service;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.error.CustumException;
import com.HUFS19.backend.error.ErrorCode;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.repository.productImg.ProductImgRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, ProductImgRepository productImgRepository) {
        this.productRepository = productRepository;
    }

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


//    public List<ProductSummary> getCategoryProducts(int category, String sort){
//        if(category==1){
//            category=null;
//        }
//    }



}
