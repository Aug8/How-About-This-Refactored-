package com.HUFS19.backend.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchConstants {
    SEARCH_UPLOADER("uploader"),
    SEARCH_PRODUCT("product"),
    SEARCH_TAG("tag")
    ;

    private final String message;
}
