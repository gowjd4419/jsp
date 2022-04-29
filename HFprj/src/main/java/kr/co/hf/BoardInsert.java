package kr.co.hf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;


/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/boardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String postTitle = request.getParameter("postTitle");
		String postAuthor = request.getParameter("postAuthor");
		String postContent = request.getParameter("postContent");
		String postType = request.getParameter("postType");
		
		
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardInsert(Integer.parseInt(postAuthor), postTitle, postContent, Integer.parseInt(postType));
		response.sendRedirect("#");
	}

}
