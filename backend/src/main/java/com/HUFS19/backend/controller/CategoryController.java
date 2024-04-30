package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoryAPI")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ApiResponseDto getAllCategory(){
        return ResponseUtils.ok(categoryService.getAll());
    }

    @GetMapping("/{categoryId}")
    public ApiResponseDto getCategoryName(@PathVariable("categoryId")int categoryId){
        return ResponseUtils.ok(categoryService.getName(categoryId));
    }

}
