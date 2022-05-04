package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;

public class BoardUpdateService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String postID = request.getParameter("postID");
		String postType = request.getParameter("postType");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.boardUpdate(postTitle, postContent, Integer.parseInt(postType), Integer.parseInt(postID));
		
	}

}
