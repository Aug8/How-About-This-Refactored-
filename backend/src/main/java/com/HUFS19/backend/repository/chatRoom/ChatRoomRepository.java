package com.HUFS19.backend.repository.chatRoom;

import com.HUFS19.backend.dto.chatRoom.ChatRoomDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository {
    int save(ChatRoom chatRoom);
    Optional<ChatRoom> findById(int id);
    Optional<ChatRoom> findByProductId(int productId);
    List<ChatRoomDetail> findByUserId(String userId);
    Optional<Integer> findByProductInquirer(int productId, String inquirerId);
}
