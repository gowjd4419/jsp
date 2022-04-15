package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// 생성자 만들기
	private DataSource ds = null;
	private static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	//게시판의 전체 글을 가져오는 getBoardList()메서드 작성
	// 전체 글을 가져오므로 List<BoardVO>를 리턴하면 됨
	// UserDAO의 getAllUserList()메서드 참조
	public List<BoardVO> getBoardList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		try {
			// getAllUserList.jsp를 참조해 아래 로직을 작성 완료하기
			// Connection 생성
			con = ds.getConnection();//context.xml 내부에 디비종류, 접속 url, mysql아이디, 비번이 기입됨.
			// 쿼리문 저장
			String sql = "SELECT * FROM boardTbl";
			// PreparedStatement에 쿼리문 입력
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 유저 한 명의 정보를 담을 수 있는 VO 생성
				BoardVO board = new BoardVO();
				// 디버깅으로 비어있는것 확인
				System.out.println("집어넣기 전 : " + board);
				// setter로 다 집어넣기
				// int를 받아올때는 rs.getInt(), Date를 받아올때는 getDate()를 씁니다.
				board.setBoardNum(rs.getInt(1)); // 앞에 시작할때 꼭 대문자써야 함
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setBdate(rs.getDate(5));
				board.setMdate(rs.getDate(6));
				board.setHit(rs.getInt(7));
				
				// 다 집어넣은 후 디버깅
				System.out.println("집어넣은 후 : " + board);
				// userList에 쌓기
				boardList.add(board);
			}
			System.out.println("리스트에 쌓인 자료 체크 : " + boardList);
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			con.close();
			pstmt.close();
			rs.close();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		}
		return boardList;
	}
	

}
