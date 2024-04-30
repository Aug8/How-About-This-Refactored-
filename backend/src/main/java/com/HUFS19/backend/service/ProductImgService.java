package com.HUFS19.backend.service;

import com.HUFS19.backend.dto.productImg.ProductImgDto;
import com.HUFS19.backend.repository.productImg.ProductImgRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductImgService {
    @Autowired
    final private ProductImgRepository productImgRepository;

    public ProductImgService(ProductImgRepository productImgRepository){
        this.productImgRepository=productImgRepository;
    }

    public List<ProductImgDto> getImg(int productId){
        return productImgRepository.findByProductId(productId);
    }}
