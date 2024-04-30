package com.HUFS19.backend.dto.chatRoom;

import com.HUFS19.backend.dto.message.LastMessageDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomDetail {
    private int id;
    private String userId;
    private String inquirerId;
    private int productId;
    private String productName;
    private LastMessageDto lastMessage;
}
