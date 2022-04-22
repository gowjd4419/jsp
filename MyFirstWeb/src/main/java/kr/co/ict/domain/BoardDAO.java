package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

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
			String sql = "SELECT * FROM boardTbl order by bdate desc";
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
	}//getBoardList마무리
	
	// boardtbl에서 row 1개를 가져오거나(글번호존재시), 안가져옴(없는글번호 입력시)
	// SELECT 구문 사용시에만 void사용안함 리턴자료형 사용
	public BoardVO getBoardDetail(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO board = new BoardVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM boardtbl WHERE board_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,boardNum);
            
            
            rs = pstmt.executeQuery();
            if(rs.next()) {
    			board.setBoardNum(rs.getInt(1));
    			board.setTitle(rs.getString(2));
    			board.setContent(rs.getString(3));
    			board.setWriter(rs.getString(4));
    			board.setBdate(rs.getDate(5));
    			board.setMdate(rs.getDate(6));
    			board.setHit(rs.getInt(7));
    			
    			}else {
    				System.out.println("계정이 없습니다.");
    			}
            
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}return board;
	} //getBoardDetail마무리
	
		public void boardInsert(String title, String content, String writer) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				String sql = "INSERT INTO boardTbl (title,content,writer) VALUES(?,?,?)";
				 pstmt = con.prepareStatement(sql);
				 
				    pstmt.setString(1, title);
		            pstmt.setString(2, content);
		            pstmt.setString(3, writer);

		            pstmt.executeUpdate();
				 
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					con.close();
					pstmt.close();
					
				    }catch(Exception e){
				    	e.printStackTrace();
				    }
			}
		}// boardInsert 마무리
		
	public void boardDelete(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM boardTbl WHERE board_num = ?";
			 pstmt = con.prepareStatement(sql);
			 
			    pstmt.setInt(1, boardNum); 

	            pstmt.executeUpdate();
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				
			    }catch(Exception e){
			    	e.printStackTrace();
			    }
	         }
	    }// boardDelete 마무리

	public void boardUpdate(String title, String content, String writer, int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();                                    // 수정날짜 고치기
			String sql = "UPDATE boardTbl SET title=?,content=?,writer=?, mdate=now() WHERE board_num=?";
			 pstmt = con.prepareStatement(sql);
			 
			    pstmt.setString(1, title); 
			    pstmt.setString(2, content); 
			    pstmt.setString(3, writer); 
			    pstmt.setInt(4, boardNum); 

	            pstmt.executeUpdate();
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				
			    }catch(Exception e){
			    	e.printStackTrace();
			    }
	         }
	}// boardUpdate 마무리
}
