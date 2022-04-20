package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;
import kr.co.ict.domain.BoardVO;

/**
 * Servlet implementation class boardInsert
 */
@WebServlet("/boardInsert")
public class boardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
			
		System.out.println(title + "," + writer + "," + content);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardInsert(title, content, writer);
		
		// /boardList로 리다이렉트(서블릿 주소로 리다이렉트시 파일이름 노출 안됨)
		response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
		//RequestDispatcher dp = request.getRequestDispatcher("/board/getBoardList.jsp");
		//dp.forward(request,response);
		// 포워딩을하려면 디비 한번더 호출해야하기 때문에 이번엔 리다이렉트 사용
	}

}
