package com.HUFS19.backend.repository.category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImp implements CategoryRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public CategoryRepositoryImp(EntityManager em){
        this.em=em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public int save(Category category) {
        em.persist(category);
        return category.getId();
    }

    @Override
    public Optional<Category> findById(int categoryId) {
        return Optional.ofNullable(em.find(Category.class, categoryId));
    }

    @Override
    public List<Category> getAll() {
        QCategory category = QCategory.category;

        return query.selectFrom(category).fetch();
    }

    @Override
    public Optional<Category> findByName(String categoryName) {
        List<Category> result = em.createQuery("select c from Category c where c.name = :categoryName", Category.class)
                .setParameter("categoryName", categoryName)
                .getResultList();

        return result.stream().findAny();

    }

}



