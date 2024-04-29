package com.HUFS19.backend.repository.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "user_id")
    private String id;
    private String password;
    private String salt;

    @Builder
    public User(String id, String password, String salt){
        this.id=id;
        this.password=password;
        this.salt=salt;
    }
}
