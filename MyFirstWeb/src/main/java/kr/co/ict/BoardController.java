package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;
import kr.co.ict.domain.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식을 처리하는 경우도 생기므로, 인코딩 설정
    	request.setCharacterEncoding("utf-8");
    	// 프론트 컨트롤러는 여러 주소 유형을 처리해야하니 uri부터 받아온다.
    	String uri = request.getRequestURI();
    	// 포워딩시 .jsp주소의 경로를 미리 저장할 변수
    	String ui = null;
    	// dao생성
    	BoardDAO dao = BoardDAO.getInstance();
    	if(uri.equals("/MyFirstWeb/boardList.do")){
    			// boardList.do를 이용해 글목록 페이지로 넘어가도록 로직 작성
    		List<BoardVO> boardList = dao.getBoardList();
    		request.setAttribute("boardList", boardList);
    		ui = "/board/getBoardList.jsp";
    	
	   }else if(uri.equals("/MyFirstWeb/boardDetail.do")) {
			// 디테일페이지 로드 로직을 직접 추가하기
		   String strBoardNum = request.getParameter("board_num");
			int boardNum = Integer.parseInt(strBoardNum);
			BoardVO board = dao.getBoardDetail(boardNum);
			request.setAttribute("board", board);
			
			ui = "/board/boardDetail.jsp";

	   }else if(uri.equals("/MyFirstWeb/boardUpdateForm.do")) {
		   request.setCharacterEncoding("utf-8");
			String boardnum = request.getParameter("board_num");
			int boardNum = Integer.parseInt(boardnum);
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			dao.boardUpdate(title, content, writer, boardNum);
			ui = "http://localhost:8181/MyFirstWeb/boardDetail?board_num=" + boardNum;
			
	   }
    	RequestDispatcher dp = request.getRequestDispatcher(ui);
    	dp.forward(request, response);

     }
}
