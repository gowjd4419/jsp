package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.BoardDAO;

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
		// post방식을 처리하는 경우도 생기므로, 인코딩 설정
    	request.setCharacterEncoding("utf-8");
    	// 프론트 컨트롤러는 여러 주소 유형을 처리해야하니 uri부터 받아온다.
    	String uri = request.getRequestURI();
    	// 포워딩시 .jsp주소의 경로를 미리 저장할 변수
    	String ui = null;
    	// dao생성
    	BoardDAO dao = BoardDAO.getInstance();
    	if(uri.equals("/MyFirstWeb/boardList.do")){
    			// boardList.do를 이용해 글목록 페이지로 넘어가도록 로직 작성
    		
	   }
    	RequestDispatcher dp = request.getRequestDispatcher(ui);
    	dp.forward(request, response);

     }
}
