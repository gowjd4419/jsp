package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

public class BoardDetailService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strPostID = request.getParameter("postID");
		
		int postID = Integer.parseInt(strPostID);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO board = dao.getBoardDetail(postID);
		
		request.setAttribute("board", board);
		
	}

}
