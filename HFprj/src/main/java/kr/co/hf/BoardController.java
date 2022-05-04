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
import kr.co.hf.service.BoardDeleteService;
import kr.co.hf.service.BoardDetailService;
import kr.co.hf.service.BoardInsertService;
import kr.co.hf.service.BoardListService;
import kr.co.hf.service.BoardUpdateFormService;
import kr.co.hf.service.BoardUpdateService;
import kr.co.hf.service.ComDeleteService;
import kr.co.hf.service.ComInsertService;
import kr.co.hf.service.ComUpdateFormService;
import kr.co.hf.service.ComUpdateService;
import kr.co.hf.service.IBoardService;
import kr.co.hf.service.IRecipeService;
import kr.co.hf.service.RecipeDetailService;

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
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
	
		String ui = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		IBoardService sv = null;
		
		IRecipeService IRsv = null;
		
		if(uri.equals("/HFprj/boardList.do")) {
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/board/getBoardList.jsp";
			
			
			
		} else if (uri.equals("/HFprj/boardDetail.do")) {
			
			sv = new BoardDetailService();
			
			sv.execute(request, response);
			
			ui = "/board/boardDetail.jsp";
			
		} else if (uri.equals("/HFprj/boardInsertForm.do")) {
			
			ui = "/board/boardInsertForm.jsp";
			
		} else if (uri.equals("/HFprj/boardInsert.do")) {
			
			sv = new BoardInsertService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		} else if (uri.equals("/HFprj/boardUpdate.do")) {
			
			sv = new BoardUpdateService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		} else if (uri.equals("/HFprj/boardUpdateForm.do")) {
			
			sv = new BoardUpdateFormService();
			
			sv.execute(request, response);
			
			ui = "/board/boardUpdateForm.jsp";
		
		} else if (uri.equals("/HFprj/boardDelete.do")) {
			
			sv = new BoardDeleteService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
		} else if (uri.equals("/HFprj/recipeDetail.do")) {
			
			IRsv = new RecipeDetailService();
			
			IRsv.execute(request, response);
			
			ui = "recipe/recipeDetail.jsp";
			
		} else if(uri.equals("/HFprj/ComUpdateForm.do")) {
			
			IRsv = new ComUpdateFormService();
			
			IRsv.execute(request, response);
			
			ui = "/Com/ComUpdateForm.jsp";
		
		} else if(uri.equals("/HFprj/ComUpdate.do")) {
			
			IRsv = new ComUpdateService();
			
			IRsv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		} else if(uri.equals("/HFprj/ComDelete.do")) {
			IRsv = new ComDeleteService();
			IRsv.execute(request, response);
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		} else if(uri.equals("/HFprj/ComInsertForm.do")) {
			
			ui = "/Com/ComInsertForm.jsp";
		
		} else if(uri.equals("/HFprj/ComInsert.do")) {
			
			IRsv = new ComInsertService();
			
			IRsv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}

}
