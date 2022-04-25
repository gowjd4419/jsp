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
 * Servlet implementation class getComDetail
 */
@WebServlet("/ComDetail")
public class getComDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getComDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentid = request.getParameter("commentID");
		int commentID = Integer.parseInt(commentid); 
		System.out.println("조회예정인 글번호 : " + commentID);
		
		ComDAO dao = ComDAO.getInstance();
		ComVO com = dao.getComDetail(commentID);
		System.out.println(com);
		
		request.setAttribute("com", com);
		
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardDetail.jsp");
		dp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
