package com.HUFS19.backend.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {
    String content;
    String SenderId;
    String date;
    String time;
}
