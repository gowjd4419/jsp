package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelect {

	public static void main(String[] args) {
		// JDBC 연동
		
		// MySQL을 연동할것임을 알리기 위해 forName 내부에 MySQL용 연동구문 적기
		// SQL 연동코드는 반드시 try~catch 블럭 내부에 넣도록 강제된다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 접속 타겟이 MySQL 8버전임을 명시
			// 커넥션 객체는 연결 여부를 확인
			// 입력요소는 접속주소, MySQL계정명, MySQL비밀번호 순으로 입력(목적지인 MySQL 서버 주소를 적기)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC",//접속할 url
					                                     "root",// DB 접속 아이디
					                                     "5613"); // DB 비밀번호
		
			// java에서 MySQL에 전송할 쿼리문을 작성
			// 쿼리문은 Statement라는 변수에 저장해서 날려줘야 함
			Statement stmt = con.createStatement();
			// .executeQuery() 내부에 실행할 쿼리문을 문자열로 작성
			// SELECT문을 실행할 때 executeQuery()를 실행
			// SELECT문을 실행한 결과 자료는 ResultSet 이라는 자료로 받을 수 있음
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");
			
			// ResultSet은 기본적으로 row 개수만큼 내부에 데이터를 저장함
			// ResultSet은 특정 번호를 집어서 조회하는 경우보다는 순차적으로
			// 모든 데이터를 조회하는 식으로 많이 사용한다.
			// 맨 처음 ResultSet은 -1번이라는 임시번호를 타겟으로 잡는다.
			// 이 번호를 옮기기 위해 .next()를 호출하면 다음 번호로 넘어간다.
			
			// rs.next(); 는 다음 자료가 남아있으면 true, 없으면 false를 리턴함
			// rs.get자료형(인덱스번호(1부터)), 혹은 rs.get자료형("컬럼명") 입력시
			// 해당 컬럼의 자료를 반환함
			// while문 반복문을 사용하면 몇 줄이 오더라도 정확하게 존재하는 row개수만큼 돌음
			while(rs.next()) {
				// 아까 본거처럼 rs.get자료형 구문을 이용해 전체 컬럼을 조회하는 구문을 내부에 작성하고 실행
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("---------------");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
