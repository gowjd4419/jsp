package kr.co.hf;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/dqwdwdwd")
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
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
	
		String ui = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		if(uri.equals("/HFprj/boardList.do")) {
			
			List<BoardVO> boardList = dao.getBoardList();
			
			request.setAttribute("boardList", boardList);
			
			ui = "/board/boardList.jsp";
			
			
			
		} else if (uri.equals("/HFprj/boardDetail.do")) {
			String postID = request.getParameter("board_num");
			
			BoardVO board = dao.getBoardDetail(Integer.parseInt(postID));
			
			request.setAttribute("board", board);
			
			ui = "/board/boardDetail.jsp";
			
		} else if (uri.equals("/HFprj/boardInsertForm.do")) {
			
			ui = "/board/boardInsertForm.jsp";
			
		} else if (uri.equals("/HFprj/boardInsert.do")) {
			
			request.setCharacterEncoding("UTF-8");
			
			String postTitle = request.getParameter("postTitle");
			String postAuthor = request.getParameter("postAuthor");
			String postContent = request.getParameter("postContent");
			String postType = request.getParameter("postType");
			
			
			dao.boardInsert(Integer.parseInt(postAuthor), postTitle, postContent, Integer.parseInt(postType));
			
			List<BoardVO> boardList = dao.getBoardList();
			
			request.setAttribute("boardList", boardList);
			
			ui = "/board/boardList.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}

}
