package com.HUFS19.backend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentDto {
    int commentId;
    String userId;
    int productId;
    String content;
    String date;
}
