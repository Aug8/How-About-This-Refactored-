package com.HUFS19.backend.repository.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(CategoryRepositoryImp.class)
@TestPropertySource(locations = "classpath:application.properties")

class CategoryRepositoryImpTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void save_findById_test() {
        Category category = Category.builder().name("testCategory").build();

        int categoryId = categoryRepository.save(category);
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(RuntimeException::new);

        assertEquals(foundCategory.getName(), category.getName());
    }

}