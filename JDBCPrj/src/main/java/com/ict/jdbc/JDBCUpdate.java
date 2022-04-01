package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {

	public static void main(String[] args) {
		// 스캐너를 이용해서
		// 수정할 아이디, 해당아이디에 대한 새로운 비번, 새로운 이름, 새로운 이메일을 입력받기
		
		// DB연동 후 쿼리문을 날려서 수정로직을 돌려주고
		
		// MySQL을 이용해 수정된 내역이 반영되었는지 확인
		
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC",
					                                     "root",
					                                     "5613");
			
			Statement stmt = con.createStatement();
			String sql = "UPDATE userinfo SET user_pw = '" + npw + "', user_name = '" + nname + "',"
					+ " email = '" + nemail + "' WHERE user_id = '" + id + "'";
			
			System.out.println("실행 예정 구문 : " + sql);
			
			stmt.executeUpdate(sql);
			
		   }catch(Exception e) {
				e.printStackTrace();
		}finally {
			scan.close(); 
		}

	}

}
