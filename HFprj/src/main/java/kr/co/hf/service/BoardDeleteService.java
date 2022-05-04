package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

public class BoardDeleteService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String postID = request.getParameter("postID");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.boardDelete(Integer.parseInt(postID));
		
		List<BoardVO> boardList = dao.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
	}

}
