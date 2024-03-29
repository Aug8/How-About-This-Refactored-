package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.HUFS19.backend.dto.product.ProductSummary;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImp implements ProductRepository
{
    private final EntityManager em;
    private JPAQueryFactory query;

    private QProduct product = QProduct.product;


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
    public Optional<Product> findByName(String productName) {
        return Optional.ofNullable(query.selectFrom(product).where(product.name.eq(productName)).fetchOne());
//        List<Product> result = em.createQuery("select p from Product p where p.name=:productName", Product.class)
//                .setParameter("productName", productName)
//                .getResultList();
//        return result.stream().findAny();

    }

    @Override
    public List<Product> findByNameLike(String name) {
        return query.selectFrom(product).where(product.name.like(name)).fetch();
//        return em.createQuery("select P from Product p where p.name like :name", Product.class)
//                .setParameter("name", name)
//                .getResultList();
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
    public List<Product> findByUploaderLike(String uploader) {
        return null;
    }

    @Override
    public List<Product> findByTagLike(String tag) {
        return null;
    }

    @Override
    public List<ProductSummary> findCategoryProducts(int categoryId, String sort) {
    return null;
    }
}
