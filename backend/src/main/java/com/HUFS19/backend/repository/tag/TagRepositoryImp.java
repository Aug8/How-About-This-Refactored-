package com.HUFS19.backend.repository.tag;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class TagRepositoryImp implements TagRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    private final  QTag tag = QTag.tag;

    public TagRepositoryImp(EntityManager em){
        this.em=em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public int save(Tag tag) {
        em.persist(tag);
        return tag.getId();
    }

    @Override
    public Optional<Tag> findById(int id) {
        return Optional.ofNullable(em.find(Tag.class, id));
    }

    @Override
    public List<String> findByProductId(int productId) {

        return query.select(tag.name).from(tag).where(tag.product.id.eq(productId)).fetch();
    }

    @Override
    public List<ProductDetailDto> findByPartialTag(String keyword, int categoryId) {
        return query.select(
                Projections.bean(
                        ProductDetailDto.class,
                        tag.product.id.as("id"),
                        tag.product.name.as("name"),
                        tag.product.user.id.as("uploader"),
                        tag.product.category.name.as("categoryName"),
                        tag.product.detail.as("detail"),
                        tag.product.link.as("link"),
                        tag.product.mainImg.as("mainImg"),
                        tag.product.date.as("date")
                )
        ).from(tag).where(tag.name.like(keyword), selectCategory(categoryId))
                .fetch();
    }

    private BooleanExpression selectCategory(int categoryId){
        return categoryId!=0?tag.product.category.id.eq(categoryId):null;
    }
}
