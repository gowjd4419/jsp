package kr.co.hf;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;


/**
 * Servlet implementation class ComList
 */
@WebServlet("/ComList")
public class getComList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getComList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String postid = request.getParameter("postID");
		String postid = "1";
		int postID = Integer.parseInt(postid);
		
		ComDAO dao = ComDAO.getInstance();
		List<ComVO> ComList = dao.getComList(postID);
		System.out.println("데이터 받아오는 지 확인" + ComList);
		
		request.setAttribute("ComList", ComList);
		
		RequestDispatcher dp = request.getRequestDispatcher("/Com/getComList.jsp");
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
