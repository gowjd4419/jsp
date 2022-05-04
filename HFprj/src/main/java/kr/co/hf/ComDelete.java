package kr.co.hf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.ComDAO;

/**
 * Servlet implementation class ComDelete
 */
@WebServlet("/ComDelete")
public class ComDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentid = request.getParameter("commentID");
		int commentID = Integer.parseInt(commentid);
		
		ComDAO dao = ComDAO.getInstance();
		dao.ComDelete(commentID);
		response.sendRedirect("http://localhost:8181/HFprj/ComList");
	}

}
