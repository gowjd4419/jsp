package kr.co.hf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.ComDAO;

/**
 * Servlet implementation class ComUpdate
 */
@WebServlet("/ComUpdate")
public class ComUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String commentid = request.getParameter("commentID");
		int commentID = Integer.parseInt(commentid);
		
		String content = request.getParameter("commentContent");
		String author = request.getParameter("commentAuthor");
		System.out.println(content);
		System.out.println(author);
		
		ComDAO dao = ComDAO.getInstance();
		dao.ComUpdate(content, author, commentID);
		// 리다이렉트(commentID번 detail페이지로 이동.)
		response.sendRedirect("http://localhost:8181/HFprj/ComDetail?commentID=" + commentID);
	}

}
