package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductSummary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {
    int save(Product product);
    //구현 필요
//    List<Product> findByCategory(int categoryId);
    List<Product> findAll(int categoryId);

    Optional<ProductDetailDto> findById(int productId);

    Optional<Product> findByName(String productName);


    List<Product> findByNameLike(String name);

    List<Product> findByUploaderLike(String uploader);
    List<Product> findByTagLike(String tag);

    List<ProductSummary> findCategoryProducts(int categoryId, String sort);

    List<ProductDetailDto> findByUserId(String userId);
}
