package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCustom
 */
// http://localhost:8181/MyFirstWeb 이후 부분만 적으면 해당 주소로 접속시
// 현재 보고 있는 서블릿이 실행된다.
@WebServlet("/spring")
public class ServletCustom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCustom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초접속");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("spring 자료가 서버 종료로 파기됩니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("spring 접속 감지");
		// request.getParameter()를 이용해
		// "jsp","boot"라는 이름으로 들어오는 요소를 콘솔을 찍도록 아래에 콘솔을 작성하기
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		String jpa = request.getParameter("jpa");
		
		
		
		System.out.println(jsp);
		System.out.println(boot);
		System.out.println(jpa);
		
		// 들어온 데이터를 콘솔이 아닌 결과화면으로 찍어보기
		// 리다이렉트를 이용해 springResult.jsp로 보내기
		//response.sendRedirect("http://localhost:8181/MyFirstWeb/servletForm/springResult.jsp");
	    
		// 데이터를 결과페이지로 보내려면 포워딩이라는 방식을 써야함
		// 포워딩 절차 1. 보내고 싶은 데이터를 request.setAttribute("저장명",자료);형식으로 저장
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		
		// request.setAttribute로 실어놓은 변수를 결과페이지로 보내기 위해 forward를 대신 사용한다.
		// 목적지 주소는 http://localhost:8181/MyFirstWeb을 생략한 나머지 주소만 적음
		// 예)/servletForm/springResult.jsp만 적기
		// 2. RequestDispatcher를 생성
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/springResult.jsp");
		// 3. forward(request, response); 실행하면 페이지가 넘어가면서 변수들도 같이 넘어감
		dp.forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// post방식으로 들어오는 접근만 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("포스트방식 접근 감지");
		// 한글이 안 깨지도록 처리
		request.setCharacterEncoding("utf-8");
		// 폼에서 보낸 데이터 자바 변수로 저장
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		String jpa = request.getParameter("jpa");
		// request.setAttribute로 받은 변수를 보낼 준비
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		// 포워딩 주소 세팅 springResult.jsp를 목표지점으로.
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/springResult.jsp");
		// 포워딩
		dp.forward(request,response);
	}

}
