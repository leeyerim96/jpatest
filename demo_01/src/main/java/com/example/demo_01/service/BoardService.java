package com.example.demo_01.service;

import com.example.demo_01.entity.Board;
import com.example.demo_01.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    // @Autowired를 통해 아래와 같이 의존성을 주입해주는 부분을 대신하여 준다.
    //private BoardRepository boardRepository = nesw BoardRepository;

    public void write(Board board) {
        this.boardRepository.save(board);
    }

    //게시글 리스트 처리
    public List<Board> boardList(){
        return  boardRepository.findAll(); // jpa의 findAll - 전체 레코드 불러오기 및 정렬 페이징 등을 관리
        // findAll을 하면 아래와 같은  코드로 이루어짐
        /* select
        board0_.id as id1_0_,
                board0_.content as content2_0_,
        board0_.title as title3_0_
                from
        board board0_ */
    }

    //게시글 리스트 페이징 처리
    public Page<Board> boardList(Pageable pageable){
        return  boardRepository.findAll(pageable);
    }

    public Page<Board> boardSearchList(String SearchKeyword,Pageable pageable){
        return boardRepository.findByTitleContaining(SearchKeyword, pageable);
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    // 게시글 삭제하기
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }

}