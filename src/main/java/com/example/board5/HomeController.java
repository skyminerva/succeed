package com.example.board5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// util.date
		Date date = new Date();
		// instance 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// formattedDate 에 dateFormat 형태로 저장.
		String formattedDate = dateFormat.format(date);
		// model 에 serverTime (key=string) formattedDate (value = object) 확장해서 생각.
		model.addAttribute("serverTime", formattedDate );
		
		// dataSource 연결. 데이타베이스
		Connection conn = dataSource.getConnection();
		
		// sql 명령문.
		String sql = "SELECT now()";
		// Statement 말고 PreparedStatement 사용.
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// query(select now())를 결과를 rs에 담는다.
		ResultSet rs = pstmt.executeQuery();
		
		// while 에서 if도 되나 해봄.
		if (rs.next()) {
				// 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 sqlTime에 저장
	            String sqlTime = rs.getString(1);
	            // String sqlTimed 을 model에 add
	            model.addAttribute("sqlTime", sqlTime);
	        }
		
		return "home";
	}
	
}
