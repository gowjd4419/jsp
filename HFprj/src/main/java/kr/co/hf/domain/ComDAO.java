package kr.co.hf.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.co.hf.domain.ComDAO;

public class ComDAO {
	private DataSource ds = null;
	private static ComDAO dao = new ComDAO();
	
	private ComDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ComDAO getInstance() {
		if(dao == null) {
			dao = new ComDAO();
		}
		return dao;
    }
	
	
	
	public List<ComVO> getComList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ComVO> ComList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM comment order by bdate desc";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ComVO com = new ComVO();
				System.out.println("집어넣기 전 : " + com);
				com.setCommentID(rs.getInt("commentID")); // 앞에 시작할때 꼭 대문자써야 함
				com.setPostID(rs.getInt("postID"));
				com.setCommentAuthor(rs.getString("commentAuthor"));
				com.setCommentContent(rs.getString("writer"));
				
				
				System.out.println("집어넣기 전 : " + com);
				ComList.add(com);
				
				
			}
			System.out.println("리스트에 쌓인 자료 체크 : " + ComList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
		}
		return ComList;
	}// getComList 끝나는지점.
}
