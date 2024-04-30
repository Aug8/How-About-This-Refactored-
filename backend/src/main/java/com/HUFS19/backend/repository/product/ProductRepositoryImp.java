package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.common.enums.SearchConstants;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductPrevDto;
import com.HUFS19.backend.dto.product.ProductSummary;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImp implements ProductRepository
{
    private final EntityManager em;
    private final JPAQueryFactory query;

    private final QProduct product = QProduct.product;


    public ProductRepositoryImp(EntityManager em){
        this.em = em;
        query = new JPAQueryFactory(em);
}

    @Override
    public int save(Product product) {
        em.persist(product);
        return product.getId();
    }

    @Override
    public List<Product> findAll(int categoryId) {
        return query.from(product).select(product).fetch();
    }

    @Override
    public Optional<ProductDetailDto> findById(int productId) {
        return Optional.ofNullable(
                query.select(
                        Projections.bean(
                                ProductDetailDto.class,
                                product.id.as("id"),
                                product.name.as("name"),
                                product.user.id.as("uploader"),
                                product.category.name.as("categoryName"),
                                product.detail.as("detail"),
                                product.link.as("link"),
                                product.mainImg.as("mainImg"),
                                product.date.as("date")
                        )
                ).from(product)
                .where(product.id.eq(productId))
                .fetchOne());
    }

    @Override
    public List<ProductDetailDto> findByPartialName(String name) {
        return query.select(
                Projections.bean(
                        ProductDetailDto.class,
                        product.id.as("id"),
                        product.name.as("name"),
                        product.user.id.as("uploader"),
                        product.category.name.as("categoryName"),
                        product.detail.as("detail"),
                        product.link.as("link"),
                        product.mainImg.as("mainImg"),
                        product.date.as("date")
                )
        ).from(product).where(product.name.like(name)).fetch();
    }

    @Override
        public List<ProductDetailDto> findByUserId(String userId) {
            return query.select(
                Projections.bean(
                        ProductDetailDto.class,
                        product.id.as("id"),
                        product.name.as("name"),
                        product.user.id.as("uploader"),
                        product.category.name.as("categoryName"),
                        product.detail.as("detail"),
                        product.link.as("link"),
                        product.mainImg.as("mainImg"),
                        product.date.as("date")
                        )
                ).from(product)
                .where(product.user.id.eq(userId))
                .fetch();
    }

    @Override
    public List<ProductPrevDto> searchProduct(String keyword, String searchOption, int categoryId) {
        return query.select(
                        Projections.bean(
                                ProductPrevDto.class,
                                product.id.as("id"),
                                product.name.as("name"),
                                product.user.id.as("uploader"),
                                product.category.name.as("categoryName"),
//                                product.detail.as("detail"),
//                                product.link.as("link"),
                                product.mainImg.as("mainImg"),
                                product.date.as("date")
                        )
                ).from(product)
                .where(selectOption(searchOption, keyword), selectCategory(categoryId))
                .fetch();
    }

    @Override
    public List<Product> findByUploaderLike(String uploader) {
        return null;
    }

    @Override
    public List<ProductSummary> findCategoryProducts(int categoryId, String sort) {
    return null;
    }

    private BooleanExpression selectCategory(int categoryId){
        return categoryId!=0?product.category.id.eq(categoryId):null;
    }

    private BooleanExpression selectOption(String option, String keyword){
        if (option.equals(SearchConstants.SEARCH_PRODUCT.getMessage())){
            return product.name.toUpperCase().contains(keyword.toUpperCase());
        } else if (option.equals(SearchConstants.SEARCH_UPLOADER.getMessage())) {
            return product.user.id.toUpperCase().contains(keyword.toUpperCase());
        } else{
            return null;
        }
    }
}
