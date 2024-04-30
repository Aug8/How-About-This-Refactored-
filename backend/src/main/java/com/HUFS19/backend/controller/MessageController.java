package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messageAPI")
public class MessageController {
    MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/chatroom/{chatroomId}/lastMessage")
    @ResponseBody
    public ApiResponseDto getLastMessage(@PathVariable("chatroomId")int chatroomId){
        return ResponseUtils.ok(messageService.getLastMessage(chatroomId));
    }

    @GetMapping("/chatroom/{chatroomId}")
    @ResponseBody
    public ApiResponseDto getRecentMessage(@PathVariable("chatroomId")int chatroomId){
        return ResponseUtils.ok(messageService.getAllMessage(chatroomId));
    }
}
