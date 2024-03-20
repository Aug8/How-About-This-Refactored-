package com.HUFS19.backend.repository.comment;

import com.HUFS19.backend.dto.comment.CommentDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class CommentRepositoryImp implements CommentRepository{
    private final EntityManager em;
    private final JPAQueryFactory query;
    private QComment comment = QComment.comment;

    public CommentRepositoryImp(EntityManager em){
        this.em=em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public int save(Comment comment) {
        em.persist(comment);
        return  comment.getId();
    }

    @Override
    public Optional<Comment> findByID(int id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    @Override
    public List<Comment> findByProductId(int productId) {
        return query.selectFrom(comment)
                .where(comment.product.id.eq(productId))
                .fetch();
    }
}
