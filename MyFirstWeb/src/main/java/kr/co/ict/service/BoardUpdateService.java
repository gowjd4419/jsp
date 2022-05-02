package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;

public class BoardUpdateService implements IBoardService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = BoardDAO.getInstance();
		String boardnum = request.getParameter("board_num");
		int boardNum = Integer.parseInt(boardnum);
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
	
		dao.boardUpdate(title, content, writer, boardNum);
	}

}
