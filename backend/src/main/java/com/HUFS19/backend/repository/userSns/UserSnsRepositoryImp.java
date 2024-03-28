package com.HUFS19.backend.repository.userSns;

import com.HUFS19.backend.dto.profile.UserSnsDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserSnsRepositoryImp implements UserSnsRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;

    public UserSnsRepositoryImp(EntityManager em){
        this.em=em;
        query = new JPAQueryFactory(em);
    }

    @Override
    public List<UserSnsDto> findByUserId(String userId) {
        QUserSns userSns = QUserSns.userSns;

        return query.select(Projections.bean(
                UserSnsDto.class,
                userSns.snsType.name.as("snsName"),
                userSns.snsLink.as("snsUrl")
        )).from(userSns)
                .where(userSns.user.id.eq(userId))
                .fetch();

    }
}
