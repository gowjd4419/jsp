package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComInsertService implements IRecipeService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ComDAO dao = ComDAO.getInstance();
		String commentAuthor = request.getParameter("commentAuthor");
		String commentContent = request.getParameter("commentContent");
		String postid = request.getParameter("postID");
		int postID = Integer.parseInt(postid); 
	 
		System.out.println(commentAuthor + "," + commentContent + "," + postID);
		dao.ComInsert(commentAuthor, commentContent, postID);
	}

}
