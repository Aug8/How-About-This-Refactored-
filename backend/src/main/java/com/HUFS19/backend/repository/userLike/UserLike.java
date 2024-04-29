package com.HUFS19.backend.repository.userLike;

import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name="user_like")
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class UserLike {
    @EmbeddedId
    private PKUserLike pk = new PKUserLike();
    @CreationTimestamp
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name="user_id")
    @MapsId("userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @MapsId("categoryId")
    private Category category;

    @Builder
    public UserLike(User user, Product product, Category category){
        this.user=user;
        this.product=product;
        this.category=category;
    }

}
