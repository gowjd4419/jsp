package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;

	
	public class BoardInsertService implements IBoardService {

		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BoardDAO dao = BoardDAO.getInstance();
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
				
			System.out.println(title + "," + writer + "," + content);
			
			dao.boardInsert(title, content, writer);
   }
  }
