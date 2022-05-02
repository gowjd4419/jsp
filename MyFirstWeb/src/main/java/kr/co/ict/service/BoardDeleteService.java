package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;

public class BoardDeleteService implements IBoardService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardDAO dao = BoardDAO.getInstance();
		String num = request.getParameter("num");
		int boardNum = Integer.parseInt(num);
		
		dao.boardDelete(boardNum);
	}
}
