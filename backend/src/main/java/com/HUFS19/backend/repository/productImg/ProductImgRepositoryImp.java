package com.HUFS19.backend.repository.productImg;

import com.HUFS19.backend.dto.productImg.ProductImgDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductImgRepositoryImp implements ProductImgRepository{
    private EntityManager em;
    private JPAQueryFactory query;
    private QProductImg productImg = QProductImg.productImg;

    public ProductImgRepositoryImp(EntityManager em){
        this.em=em;
        query = new JPAQueryFactory(em);

    }

    @Override
    public int save(ProductImg productImg) {
        em.persist(productImg);
        return productImg.getId();
    }

    @Override
    public Optional<ProductImg> findById(int productImgId) {
        return Optional.ofNullable(em.find(ProductImg.class, productImgId));
    }

    @Override
    public List<ProductImgDto> findByProductId(int productId) {

        return query.select(
                Projections.bean(
                        ProductImgDto.class,
                        productImg.id,
                        productImg.product.id.as("productId"),
                        productImg.order,
                        productImg.img
                ))
                .from(productImg)
                .where(productImg.product.id.eq(productId))
                .fetch();

    }
}
