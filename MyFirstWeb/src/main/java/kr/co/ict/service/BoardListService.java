package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.BoardDAO;
import kr.co.ict.domain.BoardVO;

// IBoardService를 구현해주는 BoardListService
public class BoardListService implements IBoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 내부에서 세션을 쓰고 싶은 경우는 세션 변수를 생성해줘야함
		// .jsp파일에서는 이미 자동생성이 되니 내장객체로 자유롭게 쓸 수 있었으나
		// 서블릿 내부에서는 생성 후에만 쓸 수 있다.
		// 단, 사용법은 동일하다.
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("s_id");
		System.out.println("로그인 아이디 :" + sId);
		// 포워딩 명령과 리다이렉트 명령이 겹치면 에러가 남.
		//if(sId == null) {
		//	response.sendRedirect("http://localhost:8181/MyFirstWeb/");
		//}
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.getBoardList();
		request.setAttribute("boardList", boardList);
		
		
		
	}

}
