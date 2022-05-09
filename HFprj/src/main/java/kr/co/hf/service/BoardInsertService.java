package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

public class BoardInsertService implements IBoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String postTitle = request.getParameter("postTitle");
		String strPostAuthor = request.getParameter("postAuthor");
		String postContent = request.getParameter("postContent");
		String strPostType = request.getParameter("postType");
		
		int postAuthor = Integer.parseInt(strPostAuthor);
		int postType = Integer.parseInt(strPostType);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.boardInsert(postAuthor, postTitle, postContent, postType);
		
		
	}
}
