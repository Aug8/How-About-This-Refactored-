package com.HUFS19.backend.repository.product;

import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.user.User;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
@Entity
@Table(name="product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//전체적으로 @Column 추가
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "detail")
    private String detail;
    @Column(name = "link")
    private String link;
    @Column(name = "main_img")
    private String mainImg;
    @Column(name = "date")
    @CreationTimestamp
    private Timestamp date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", updatable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryId", updatable = false)
    private Category category;

    @Builder
    public Product(String name, String detail, String link, String mainImg, User user, Category category){
        this.name=name;
        this.detail=detail;
        this.link=link;
        this.mainImg = mainImg;
        this.user=user;
        this.category=category;
    }

}
