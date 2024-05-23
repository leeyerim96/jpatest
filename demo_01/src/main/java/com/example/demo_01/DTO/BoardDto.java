package com.example.demo_01.DTO;
import com.example.demo_01.entity.Board;
import lombok.Data;

@Data
public class BoardDto {
    private Integer id;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }


}
