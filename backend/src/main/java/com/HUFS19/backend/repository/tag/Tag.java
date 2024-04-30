package com.HUFS19.backend.repository.tag;

import com.HUFS19.backend.repository.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
    private Product product;
    @Column(name = "tag_name")
    private String name;

    @Builder
    public Tag(Product product, String name){
        this.product=product;
        this.name=name;
    }
}
