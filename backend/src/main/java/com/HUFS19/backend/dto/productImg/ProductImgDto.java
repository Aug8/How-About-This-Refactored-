package com.HUFS19.backend.dto.productImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImgDto {
    private int id;
    private int productId;
    private int order;
    private String img;
}
