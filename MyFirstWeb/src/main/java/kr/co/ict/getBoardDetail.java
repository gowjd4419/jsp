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
 * Servlet implementation class getBoardDetail
 */
@WebServlet("/boardDetail")
public class getBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameter()는 무조건 문자로만 데이터를 전달함
		String strBoardNum = request.getParameter("board_num");
		int boardNum = Integer.parseInt(strBoardNum); // 위에 저장된 문자1을 숫자 1 정수로 바꿔줘야함.
		System.out.println("조회예정인 글번호 : " + boardNum);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(boardNum);
		System.out.println(board);
		
		request.setAttribute("board", board);
		
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardDetail.jsp");
		dp.forward(request,response);

	}

	private getBoardDetail board() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	private static getBoardDetail getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
