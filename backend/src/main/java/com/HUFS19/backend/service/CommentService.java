package com.HUFS19.backend.service;

import com.HUFS19.backend.common.util.DateConvertUtils;
import com.HUFS19.backend.dto.comment.CommentDto;
import com.HUFS19.backend.dto.message.MessageDto;
import com.HUFS19.backend.repository.comment.Comment;
import com.HUFS19.backend.repository.comment.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public List<CommentDto> getCommentOfProduct(int productId){
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream().map(c->
                new CommentDto(
                        c.getId(),
                        c.getUser().getId(),
                        c.getProduct().getId() ,
                        c.getContent(),
                        DateConvertUtils.getDate(c.getDate())+" "+DateConvertUtils.getTime(c.getDate())
                )).toList();
    }
}
