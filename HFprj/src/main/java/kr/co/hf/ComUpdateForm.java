package kr.co.hf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

/**
 * Servlet implementation class ComUpdateForm
 */
@WebServlet("/ComUpdateForm")
public class ComUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComUpdateForm() {
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
		ComVO com = dao.getComDetail(commentID);
		
		request.setAttribute("com", com);
		
		RequestDispatcher dp = request.getRequestDispatcher("/Com/ComUpdateForm.jsp");
		dp.forward(request,response);
	}

}
