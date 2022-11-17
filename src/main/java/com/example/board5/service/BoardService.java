package com.example.board5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board5.dao.BoardDao;
import com.example.board5.vo.BoardVo;
import com.mysql.cj.Session;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 셀렉트 나우 처리
	public String selectNow() throws Exception{
		return boardDao.selectNow();
	}
	
	// 게시판 전체
	public List<BoardVo> selectBoardAll() throws Exception  {
		return boardDao.selectBoardAll();
	}
	
	// 게시판 한개
	public BoardVo selectBoard(int id) throws Exception {
		return boardDao.selectBoard(id);
	}
	// 게시판 추가
	public int insertBoard(BoardVo boardVo) throws Exception {
		return boardDao.insertBoard(boardVo);
	}
	// 게시판 삭제
	public int deleteBoard(int id) {
		return boardDao.deleteBoard(id);
	}
}
