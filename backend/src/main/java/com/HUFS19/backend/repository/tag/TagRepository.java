package com.HUFS19.backend.repository.tag;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductPrevDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository {
    int save(Tag tag);

    Optional<Tag> findById(int id);

    List<String> findByProductId(int productId);

    List<ProductPrevDto> findByPartialTag(String keyword, int categoryId);
}
