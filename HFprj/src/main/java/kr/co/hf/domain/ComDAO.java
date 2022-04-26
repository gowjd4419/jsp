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
	
	
	
	public List<ComVO> getComList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ComVO> ComList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM comment WHERE postID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,postID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ComVO com = new ComVO();
				System.out.println("집어넣기 전 : " + com);
				com.setCommentID(rs.getInt("commentID")); // 앞에 시작할때 꼭 대문자써야 함
				com.setPostID(rs.getInt("postID"));
				com.setCommentAuthor(rs.getString("commentAuthor"));
				com.setCommentContent(rs.getString("commentContent"));
				
				
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
	
	public ComVO getComDetail(int commentID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComVO Com = new ComVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM comment WHERE commentID =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,commentID);
            
            
            rs = pstmt.executeQuery();
            if(rs.next()) {
    			Com.setCommentID(rs.getInt(1));
    			Com.setPostID(rs.getInt(2));
    			Com.setCommentAuthor(rs.getString(3));
    			Com.setCommentContent(rs.getString(4));
    			
    			
    			}else {
    				System.out.println("댓글이 없습니다.");
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
		}
		return Com;
	}//getComDetail 마무리
	
	public void ComInsert(String commentContent,String commentAuthor, int postID, int commentID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO comment (commentContent,commentAuthor,postID,commentID) VALUES(?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			 
			    pstmt.setString(1, commentContent);
			    pstmt.setString(2, commentAuthor);
			    pstmt.setInt(3, postID);
			    pstmt.setInt(4, commentID);
	           
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
	}// ComInsert 마무리
	
	public void ComDelete(int commentID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM comment WHERE commentID = ?";
			 pstmt = con.prepareStatement(sql);
			 
			    pstmt.setInt(1, commentID); 

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
	    }// ComDeletet 마무리
	
	public void ComUpdate(String commentContent, String commentAuthor, int commentID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();                                    
			String sql = "UPDATE comment SET commentContent=?,commentAuthor=? WHERE commentID=?";
			 pstmt = con.prepareStatement(sql);
			 
			    pstmt.setString(1, commentContent); 
			    pstmt.setString(2, commentAuthor);  
			    pstmt.setInt(3, commentID); 
			    //pstmt.setInt(3, postID); 

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
	   }// ComUpdate 마무리
	
}
