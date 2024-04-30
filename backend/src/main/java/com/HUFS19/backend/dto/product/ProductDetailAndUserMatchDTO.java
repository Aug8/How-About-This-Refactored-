package com.HUFS19.backend.dto.product;

import com.HUFS19.backend.dto.auth.LoginStatusDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ProductDetailAndUserMatchDTO {
    private int id;
    private String name;
    private String uploader;
    private int categoryId;
    private String detail;
    private String mainImg;
    private Timestamp date;
    private LoginStatusDto loginStatus;
}
