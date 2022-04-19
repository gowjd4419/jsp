package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class boardInsertForm
 */
@WebServlet("/boardInsertForm")
public class boardInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달데이터가 없으므로(바인딩을 하지 않으므로) 리다이렉트로 처리해도 기능적으로 차이는 없으나
		// 리다이렉트로 처리할 경우 파일명이나 폴더구조가 일부 노출될 수 있어 포워딩으로 처리.
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardInsertForm.jsp");
		dp.forward(request,response);
	}

}
