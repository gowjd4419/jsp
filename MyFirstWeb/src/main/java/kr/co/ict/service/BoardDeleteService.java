package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.BoardDAO;

public class BoardDeleteService implements IBoardService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// post로 보낸 아이디를 받으니 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("s_id");
		// boardDetail.jsp의 삭제버튼을 눌렀을때 board_writer도 같이 히든으로 보내므로
		// board_writer를 받아서 비교할 수 있다.
		// 아이디가 일치하는 경우만 아래의 delete로직이 호출되도록 조건문으로 감싸주기
		String writer = request.getParameter("board_writer");
		if(sId != null && sId.equals(writer)) {
			BoardDAO dao = BoardDAO.getInstance();
			String num = request.getParameter("num");
			int boardNum = Integer.parseInt(num);
			
			dao.boardDelete(boardNum);

			}
	}
}
