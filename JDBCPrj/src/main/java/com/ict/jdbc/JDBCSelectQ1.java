package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCSelectQ1 {

	public static void main(String[] args) {
		// Scanner를 이용해 user_id를 입력받은 다음
		// 방금 배운 SELECT문 실행 구문들을 응용해서
		// WHERE user_id = 입력받은 아이디 형식으로
		// 내가 조회한 아이디의 정보만
		// 콘솔에 찍히도록 로직을 작성
		
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 아이디를 입력해주세요 : ");
		String userId = scan.nextLine();
		// WHERE절이
		// WHERE user_id = '아이디명'과 같이 따음표가 포함됨
		// 힌트 : user_id='" + 변수명 + "'"
		
		// 0. Scanner 생성
		// 1.JDBC 연동
		// 2.Statement 구문 생성
		// 3.쿼리문 실행
		// 4.rs받아와서 출력
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC",//접속할 url
					                                     "root",
					                                     "5613");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM userinfo WHERE user_id = '" + userId + "'";
			System.out.println("실행 예정 구문 : " + sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("---------------");
			}
		    
			
		   }catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


