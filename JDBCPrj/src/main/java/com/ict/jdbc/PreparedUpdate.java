package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedUpdate {

	public static void main(String[] args) {
		// 특정 id입력시 id,pw,name,email 입력받은 값으로 갱신하는 UPDATE로직

		String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
        Scanner scan = new Scanner(System.in);
		
		System.out.print("정보를 바꾸고 싶은 아이디를 입력해주세요.");
		String id = scan.nextLine();
		System.out.print("새로운 비밀번호를 입력해주세요.");
		String npw = scan.nextLine();
		System.out.print("새로운 이름을 입력해주세요.");
		String nname = scan.nextLine();
		System.out.print("새로운 이메일을 입력해주세요.");
		String nemail = scan.nextLine();
		
        try {
			
			Class.forName(dbType);
			
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			                                                             // WHERE조건이 붙기 이전에 ,콤마같은것을 붙이면 입력이 안됨 주의할것
			String sql = "UPDATE userinfo SET user_pw = ?, user_name = ?, email = ? WHERE user_id = ?";
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, npw); // 번호 순서는 상관이 없음 ?가 채워져있기만 하면됨
			pstmt.setString(2, nname);
			pstmt.setString(3, nemail);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			
		}finally {
			scan.close();
		}

	}

}
