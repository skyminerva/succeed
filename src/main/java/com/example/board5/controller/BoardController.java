package com.example.board5.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board5.service.BoardService;
import com.example.board5.vo.BoardVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private	BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String selectNow(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// util.date
		Date date = new Date();
		// instance 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// formattedDate 에 dateFormat 형태로 저장.
		String formattedDate = dateFormat.format(date);
		// model 에 serverTime (key=string) formattedDate (value = object) 확장해서 생각.
		model.addAttribute("serverTime", formattedDate );
		
		// 서비스 처리 값
		String result = boardService.selectNow();
		// model add
		model.addAttribute("selectNow", result);
		// home.jsp 에 표시.
		return "home";
	}
	
	// 게시판 전체 조회
	@RequestMapping(value = "/boardAll", method = RequestMethod.GET)
	public ModelAndView selectBoardAll() throws Exception {
		
		List<BoardVo> resultList = boardService.selectBoardAll();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/boardAll");
		
		mav.addObject("board", resultList);
		
		return mav;
		
	}
	
	// 게시판 한개 조회
	@RequestMapping(value = "/selectBoard", method = RequestMethod.GET)
	public String selectBoard(@RequestParam int id) throws Exception {
		
		// 게시글 조회 처리
		BoardVo boardVo = boardService.selectBoard(id);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/selcetBoard");
		
		mav.addObject("selectBoard", boardVo);
		
		return "selectBoard";
	}
	
	// 게시판 작성
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertBoard(BoardVo boardVo) throws Exception {
		
		boardService.insertBoard(boardVo);

		return "board";
	}
	// 게시판 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public void deleteBoard(int id) {
		boardService.deleteBoard(id);
	}
	
	
	// write 화면 (이 화면도 안나옴)
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVo boardVo) throws Exception{
		logger.info("write");
		
		boardService.insertBoard(boardVo);
		
		return "home";

	}
}