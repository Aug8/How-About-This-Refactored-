package com.HUFS19.backend.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchResponse {
    private int id;
    private String name;
    private String uploader;
    private String categoryName;
    private String detail;
    private String link;
    private String MainImg;
    private String date;
}
