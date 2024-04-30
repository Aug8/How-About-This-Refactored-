package com.HUFS19.backend.repository.userSns;

import com.HUFS19.backend.repository.snsType.SnsType;
import com.HUFS19.backend.repository.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserSns {
    @EmbeddedId
    private PKUserSns pk;

    @Column(name = "sns_link")
    private String snsLink;

    @ManyToOne
    @JoinColumn(name = "sns_id")
    @MapsId("snsId")
    SnsType snsType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("userId")
    User user;
}
