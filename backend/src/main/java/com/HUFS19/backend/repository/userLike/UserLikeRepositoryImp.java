package com.HUFS19.backend.repository.userLike;

import com.HUFS19.backend.common.util.DateConvertUtils;
import com.HUFS19.backend.dto.product.ProductDetailDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.apache.commons.lang3.time.DateUtils;

import java.util.List;
import java.util.Optional;

public class UserLikeRepositoryImp implements UserLikeRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QUserLike userLike = QUserLike.userLike;

    public UserLikeRepositoryImp(EntityManager em){
        this.em=em;
        this.query=new JPAQueryFactory(em);
    }

    @Override
    public List<ProductDetailDto> getLikedProduct(String userId) {
        return query.select(
                Projections.bean(
                        ProductDetailDto.class,
                        userLike.product.id.as("id"),
                        userLike.product.name.as("name"),
                        userLike.user.id.as("uploader"),
                        userLike.category.name.as("categoryName"),
                        userLike.product.detail.as("detail"),
                        userLike.product.link.as("link"),
                        userLike.product.mainImg.as("mainImg"),
                        userLike.product.date.as("date")
                )).from(userLike)
                .where(userLike.user.id.eq(userId))
                .fetch();
    }

    @Override
    public Optional<UserLike> getProductLikeStatus(int productId, String userId) {
        return Optional.ofNullable(
                query.selectFrom(userLike).where(userLike.product.id.eq(productId).and(userLike.user.id.eq(userId))).fetchOne()
        );
    }
}
