package com.ict.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedSelect {

	public static void main(String[] args) {
		
		// DB종류, 주소, 아이디, 비밀번호는 간단하게 변수로 관리하는게 가독성이 더 좋다.
		// 변수로 상단에 미리 선언해놓고 쓰도록 하기
		String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
		
		// 조회할 아이디 입력받기
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 아이디를 입력해주세요.");
		String id = scan.nextLine();
		
		try {
			// 직접 적지 않고 변수명으로 관리하기 때문에 훨씬 가독성이 높아짐
			// 1.DB종류 지점
			Class.forName(dbType);
			// 2. DB연결
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			// 3. PreparedStatment 구문은 먼저 SQL쿼리문을 만들어놓고 ?를 채우는 식으로 작동함
			//    쿼리문 작성시 중간에 사용자가 입력하는 부분에 대해서만 ?로 대체해서 적는다.
			//    따옴표 여부는 더이상  고려하지 않아도 됨.
			//    ?는 두 개 이상을 나열할 수도 있음
			String sql = "SELECT * FROM userinfo WHERE user_id=?"; //? 가 사용자 입력아이디 부분
			
			// pstmt 변수를 만들어 세팅하면서 sql 구문을 같이 넣어주기
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// ?에 들어갈 자료를 정의해줌
			// String sql = "SELECT * FROM userinfo WHERE user_id=?"; => SELECT * FROM userinfo WHERE user_id='내가 입력할 아이디' 
			// 물음표 지점에 setString 을 주었기 때문에 (String=문자 이기때문)''이것만 붙이면 됨 만일 segInt라면 ''이것도 필요없음
			pstmt.setString(1, id);// 왼쪽부터 1번째 ?에 id변수에 들어있는 사용자 입력 변수를 넣어준다는 의미
			
			// 4. 쿼리문 실행(SELECT구문의 실행결과는 여전히 ResultSet으로 받는다.)
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 해당 아이디 정보를 콘솔에 찍고, 없는 아이디면 아이디가 없다고 출력
			
			if(rs.next()) {
				System.out.println(rs.getString("user_id"));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString("email")); // 번호가 아닌 직접 데이터를 입력해줘도 나옴
				System.out.println("---------------");
			}else {
				System.out.println(id + "는 없는 아이디입니다.");
			}
			
			
		}catch(Exception e) {
			
		}finally {
			scan.close();
		}

	}

}
