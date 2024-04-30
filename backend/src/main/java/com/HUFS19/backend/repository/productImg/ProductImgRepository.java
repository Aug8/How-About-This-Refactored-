package com.HUFS19.backend.repository.productImg;

import com.HUFS19.backend.dto.productImg.ProductImgDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductImgRepository {
    int save(ProductImg productImg);

    Optional<ProductImg> findById(int productImgId);

    List<ProductImgDto> findByProductId(int productId);
}
