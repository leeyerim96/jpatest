package com.example.demo_01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class Board {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @Builder
    public Board(
            Integer id,
            String title,
            String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}