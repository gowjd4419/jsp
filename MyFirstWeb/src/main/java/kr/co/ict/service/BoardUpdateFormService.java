package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;
import kr.co.ict.domain.BoardVO;

public class BoardUpdateFormService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		String boardnum = request.getParameter("board_num");
		int boardNum = Integer.parseInt(boardnum);
		
		BoardVO board = dao.getBoardDetail(boardNum);
		
		request.setAttribute("board", board);
		
	}

}
