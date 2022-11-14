package com.example.board5.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board5.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private	BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
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
	
}