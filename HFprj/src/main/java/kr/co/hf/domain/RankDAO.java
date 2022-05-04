package kr.co.hf.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RankDAO {
	
	
	private DataSource ds;

	public static RankDAO dao = new RankDAO();
	
	private RankDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static RankDAO getInstance() {
		
		if(dao == null) {
			dao = new RankDAO();
		}
		return dao;
	}
	
	public List<RankVO> getRankOrderedList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<RankVO> rankList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM ranking ORDER BY rankPosition ASC LIMIT 3";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < 10; i++) {
				if(rs.next()) {
					RankVO rank = new RankVO();
					rank.setRankID(rs.getInt(1));
					rank.setPostID(rs.getInt(2));
					rank.setRankPosition(rs.getInt(3));
					rankList.add(rank);
					
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
		return rankList;
		
		
	}
	
	public void updateRank(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String s = "UPDATE ranking SET rankPosition=? WHERE postID=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
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
		return;
	}
	
	public void insertRank(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String s = "INSERT INTO ranking VALUES (?,?,?) WHERE postID=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			pstmt.setInt(1, postID);
			pstmt.setInt(1, postID);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	public void deleteRank(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String s = "DELETE FROM ranking WHERE rankID=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
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
		return;
	}
	
	public int getCount(){
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			con = ds.getConnection();
			String s = "DELETE FROM ranking WHERE rankID=?";
			pstmt = con.prepareStatement(s);
			count = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}