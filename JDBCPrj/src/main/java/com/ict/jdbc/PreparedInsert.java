package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedInsert {

	public static void main(String[] args) {
		// insert구문을 구현하기
		// Scanner로 id, pw, name, email을 입력받아서
		// INSERT 구문의 ?를 채우고
		// ?가 네 개 이므로 주의해주기
		
		String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
	
        Scanner scan = new Scanner(System.in);
		
		System.out.print("가입시 사용할 아이디를 입력해주세요.");
		String id = scan.nextLine();
		System.out.print("가입시 사용할 비밀번호를 입력해주세요.");
		String pw = scan.nextLine();
		System.out.print("가입시 사용할 이름을 입력해주세요.");
		String name = scan.nextLine();
		System.out.print("가입시 사용할 이메일을 입력해주세요.");
		String email = scan.nextLine();
		
		try {
			
			Class.forName(dbType);
			
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			
			String sql = "INSERT INTO userinfo VALUES (?, ?, ?, ?)";
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			
		}finally {
			scan.close();
		}

	}

}
