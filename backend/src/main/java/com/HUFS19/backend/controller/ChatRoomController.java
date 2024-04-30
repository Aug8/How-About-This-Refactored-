package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.chatRoom.ChatRoomDetail;
import com.HUFS19.backend.service.ChatRoomService;
import com.HUFS19.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chatroomAPI")
public class ChatRoomController {

    ChatRoomService chatRoomService;
    MessageService messageService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService, MessageService messageService){
        this.chatRoomService=chatRoomService;
        this.messageService=messageService;
    }

    @GetMapping("/{userId}/chatRoomLIst")
    @ResponseBody
    public ApiResponseDto getChatRoomList(@PathVariable("userId") String userId){
        List<ChatRoomDetail> chatRoomList=chatRoomService.getChatRoomList(userId);
        chatRoomList.forEach(r->r.setLastMessage(messageService.getLastMessage(r.getId())));

        return ResponseUtils.ok(chatRoomList);
    }

    @GetMapping("/{productId}/chat/{inquirerId}")
    @ResponseBody
    public ApiResponseDto getChatRoom(@PathVariable("productId") int productId, @PathVariable("inquirerId") String inquirerId){
        return ResponseUtils.ok((chatRoomService.getChatRoom(productId, inquirerId)));
    }


}
