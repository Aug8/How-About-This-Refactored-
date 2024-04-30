package com.HUFS19.backend.repository.message;

import com.HUFS19.backend.dto.message.LastMessageDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository public interface MessageRepository {
    int save(Message message);
    Optional<Message> findById(int id);

    List<Message> findAllByChatRoom(int chatRoomId);

    Optional<Message> findLastByChatRoom(int chatRoomId);
}
