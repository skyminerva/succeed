package com.example.board5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc connection test 
 */
public class ConnectionTest {
    public static void main(String[] args) throws Exception {
    	
    	//  DB_URL, DB_USER, DB_PASSWORD 는 root-context 에 bean으로 들어감.
        // 스키마의 이름(springbasic)이 다른 경우 설정해주어야 함
        String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";
        
        // DB의 userid와 pwd를 설정.
        String DB_USER = "jiwon";
        String DB_PASSWORD = "0000";

        // 데이터베이스의 연결
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
        // Statement를 생성. PreparedStatement를 사용해야 한다. injection 공격 가능>> 제대로 모르는 것 우선 넘어감.
        Statement stmt  = conn.createStatement(); 

        // 시스템의 현재 날짜시간을 출력하는 sql.
        String query = "SELECT now()"; 
        // query(select now())를 결과를 rs에 담는다. 
        ResultSet rs = stmt.executeQuery(query); 

        // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
        while (rs.next()) {
        	 // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            String curDate = rs.getString(1); 
            // console에 curDate를 출력.  datetime이 나와야 정상.
            System.out.println(curDate);
        }
    }
}