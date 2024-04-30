package com.HUFS19.backend.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LastMessageDto {
    String date;
    String content;
}
