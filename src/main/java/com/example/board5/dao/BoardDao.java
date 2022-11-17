package com.example.board5.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board5.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	// selectNow 
	public String selectNow() throws Exception {
		// sql 실행
		return session.selectOne("com.example.board5.dao.BoardMapper.selectNow");
	}
	
	// 게시판 전체
	public List<BoardVo> selectBoardAll() throws Exception {
		return session.selectList("com.example.board5.dao.BoardMapper.selectBoardAll");
	}
	
	// 셀렉트 게시판 한개 
	public BoardVo selectBoard(int id) throws Exception {
		return session.selectOne("com.example.board5.dao.BoardMapper.selectBoard", id);
	}
	
	// 게시판 등록
	public int insertBoard(BoardVo boardVo) throws Exception {
		return session.insert("com.example.board5.dao.BoardMapper.insertBoard", boardVo);
	}
	// 게시판 삭제
	public int deleteBoard(int id) {
		return session.delete("com.example.board5.dao.BoardMapper.insertBoard", id);
	}
	
	// 게시판 수정
	public int updateBoard(BoardVo boardVo) {
		return session.update("com.example.board5.dao.BoardMapper.updateBoard", boardVo);
	}
}
