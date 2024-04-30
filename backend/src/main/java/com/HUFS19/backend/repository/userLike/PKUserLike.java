package com.HUFS19.backend.repository.userLike;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class PKUserLike implements Serializable {
    @Column(name = "user_id")
    private String userId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "category_id")
    private int categoryId;

    public PKUserLike(String userId, int productId, int categoryId){
        this.userId = userId;
        this.productId = productId;
        this.categoryId = categoryId;
    }
}
