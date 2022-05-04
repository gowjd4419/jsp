package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComDeleteService implements IRecipeService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String commentid = request.getParameter("commentID");
		int commentID = Integer.parseInt(commentid);
		String postID = request.getParameter("postID");
		
		System.out.println(commentID);
		System.out.println(postID);
		ComDAO dao = ComDAO.getInstance();
		dao.ComDelete(commentID);
	}

}
