package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/productAPI")
public class TagController {
    @Autowired
    TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping("/{productId}/tags")
    @ResponseBody
    public ApiResponseDto getTags(@PathVariable("productId")int productId){
        List<String> tags = tagService.getTags(productId);
        //비어있어도 success
        return ResponseUtils.ok(tags);
    }
}
