package kr.co.hf.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDAO {
	
	
	private DataSource ds;

	public static LikeDAO dao = new LikeDAO();
	
	private LikeDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static LikeDAO getInstance() {
		
		if(dao == null) {
			dao = new LikeDAO();
		}
		return dao;
	}
	
	
	
	public List<LikeVO> getLikeOrderedList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<LikeVO> likeList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM rank ORDER BY rankPosition DESC";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < 10; i++) {
				if(rs.next()) {
					LikeVO like = new LikeVO();
					like.setLikeID(rs.getInt(1));
					like.setPostID(rs.getInt(3));
					like.setUserID(rs.getInt(4));
                    like.setLikeType(rs.getInt(2));
					likeList.add(like);
					
				}
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return likeList;
		
		
	}
	

	
	
	
		
	
}