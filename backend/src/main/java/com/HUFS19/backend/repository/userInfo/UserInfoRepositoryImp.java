package com.HUFS19.backend.repository.userInfo;

import com.HUFS19.backend.dto.profile.ProfileDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class UserInfoRepositoryImp implements UserInfoRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    public UserInfoRepositoryImp(EntityManager em){
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public String save(UserInfo userInfo) {
        em.persist(userInfo);
        return userInfo.getUser().getId();
    }

    @Override
    public Optional<ProfileDto> findByUserId(String userId) {
        QUserInfo userInfo = QUserInfo.userInfo;

        return Optional.ofNullable(
                query.select(
                        Projections.bean(
                                ProfileDto.class,
                                userInfo.user.id.as("userId"),
                                userInfo.icon.as("icon"),
                                userInfo.introduce.as("introduce"),
                                userInfo.nickname.as("nickname")
                        )
                ).from(userInfo)
                .where(userInfo.user.id.eq(userId))
                .fetchOne()
        );
    }
}
