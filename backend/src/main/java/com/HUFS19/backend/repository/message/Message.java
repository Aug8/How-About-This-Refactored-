package com.HUFS19.backend.repository.message;

import com.HUFS19.backend.repository.category.Category;
import com.HUFS19.backend.repository.chatRoom.ChatRoom;
import com.HUFS19.backend.repository.product.Product;
import com.HUFS19.backend.repository.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "msg_id")
    private int id;

    private String content;

    @CreationTimestamp
    private Timestamp time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chatRoomId")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquirerId")
    private User inquirer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private User sender;


}
