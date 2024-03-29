package com.HUFS19.backend.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ProductDetailDto {
    private int id;
    private String name;
    private String uploader;
    private String categoryName;
    private String detail;
    private String link;
    private String mainImg;
    private Timestamp date;
}
