package com.example.board5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board5.dao.BoardDao;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public String selectNow() throws Exception{
		return boardDao.selectNow();
	}
	
	
}
