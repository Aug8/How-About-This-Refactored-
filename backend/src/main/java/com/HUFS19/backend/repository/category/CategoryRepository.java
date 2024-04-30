package com.HUFS19.backend.repository.category;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository {
    int save(Category category);

    Optional<Category> findById(int categoryId);

    List<Category> getAll();
    Optional<Category> findByName(String categoryName);

}
