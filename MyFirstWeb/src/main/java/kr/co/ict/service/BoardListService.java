package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.BoardButtonDTO;
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
		
		// pageNum으로 들어오는 값을 받아서  getBoardList에 넣어주기
		// pageNum이 안 들어왔을때 자동으로 1이 getBoardList에 들어가도록 조치해주기
		
		String pagenum = request.getParameter("pageNum");
		// 위의 pagenum이 null이냐 아니냐에 따라 달라져야 하는데 null인경우 1로 처리하도록
		// null이 아닌 경우는 그냥 바로 해당 페이지를 보여주도록 처리하기
		
		int pageNum = 1;
		
		if(pagenum != null){
			pageNum = Integer.parseInt(pagenum);
	    }
		
		
		BoardDAO dao = BoardDAO.getInstance();
		int boardCount = dao.getBoardCount(); // 글 갯수를 얻어오기.
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);// 밑에 깔아줘야 하는 버튼에 대한 정보 추가
		
		// 바인딩해서 넘긴 다음, 결과페이지에서 수치정보 확인
		request.setAttribute("buttons", buttons);
		
		List<BoardVO> boardList = dao.getBoardList(pageNum);
		request.setAttribute("boardList", boardList);
		
		
		
	}

}
