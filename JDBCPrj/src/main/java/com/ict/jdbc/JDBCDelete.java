package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		// Scanner로 삭제할 아이디를 입력받으면
		
		// DB에 삭제용 쿼리문을 날려주는 로직을 작성하기
		
		// 삭제되었는지는 SELECT 코드나 혹은 MySQL을 이용해 확인
		
        Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디를 입력해주세요.");
		String id = scan.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC",
					                                     "root",
					                                     "5613");
			
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM userinfo WHERE user_id = '" + id +"'";
			
			System.out.println("실행 예정 구문 : " + sql);
			
			stmt.executeUpdate(sql);
			
		   }catch(Exception e) {
				e.printStackTrace();
		}finally {
			scan.close(); //스캐너 종료 써도되고 안써도 되고 쓰면 좋음
		}
	}
}
