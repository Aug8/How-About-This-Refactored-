package com.HUFS19.backend.repository.comment;

import com.HUFS19.backend.dto.comment.CommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository {
    int save(Comment comment);
    Optional<Comment> findByID(int id);

    List<Comment> findByProductId(int productId);
}
