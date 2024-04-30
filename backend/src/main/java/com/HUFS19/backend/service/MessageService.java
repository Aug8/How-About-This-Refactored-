package com.HUFS19.backend.service;

import com.HUFS19.backend.common.util.DateConvertUtils;
import com.HUFS19.backend.dto.message.LastMessageDto;
import com.HUFS19.backend.dto.message.MessageDto;
import com.HUFS19.backend.repository.message.Message;
import com.HUFS19.backend.repository.message.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageService {
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<MessageDto> getAllMessage(int ChatRoomId){
        List<Message> messageList= messageRepository.findAllByChatRoom(ChatRoomId);
        return messageList.stream().map(message -> new MessageDto(
                message.getContent(),
                message.getSender().getId(),
                DateConvertUtils.getDate(message.getTime()),
                DateConvertUtils.getTime(message.getTime())
        )).toList();
    }

    public LastMessageDto getLastMessage(int ChatRoomId) {
         Optional<Message> lastMessage = messageRepository.findLastByChatRoom(ChatRoomId);

        return lastMessage.map(message -> new LastMessageDto(DateConvertUtils.getDate(message.getTime()), message.getContent()))
                .orElseGet(() -> new LastMessageDto("", "최근 메세지를 확인할 수 없습니다."));

    }

}
