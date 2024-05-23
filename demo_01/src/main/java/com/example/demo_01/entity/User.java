package com.example.demo_01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_idx;
    private String userId;
    private String email;
    private String userNm;
    private String password;
    private String salt;

    @Builder
    public User(
            Integer user_idx,
            String userId,
            String email,
            String userNm,
            String password,
            String salt) {
        this.user_idx = user_idx;
        this.userId = userId;
        this.email = email;
        this.userNm = userNm;
        this.password = password;
        this.salt = salt;
    }

}