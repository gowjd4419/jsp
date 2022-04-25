package kr.co.hf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.ComDAO;

/**
 * Servlet implementation class ComInsert
 */
@WebServlet("/ComInsert")
public class ComInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String commentAuthor = request.getParameter("commentAuthor");
		String commentContent = request.getParameter("commentContent");
		String commentid = request.getParameter("commentID");
		String postid = request.getParameter("postID");
		
		int commentID = Integer.parseInt(commentid); 
		int postID = Integer.parseInt(postid); 
			
		System.out.println(commentAuthor + "," + commentContent + "," + commentID + "," + postID);
		
		ComDAO dao = ComDAO.getInstance();
		dao.ComInsert(commentAuthor, commentContent, commentID, postID);
		
		// /boardList로 리다이렉트(서블릿 주소로 리다이렉트시 파일이름 노출 안됨)
		response.sendRedirect("http://localhost:8181/MyFirstWeb/ComList");
		// 포워딩을하려면 디비 한번더 호출해야하기 때문에 이번엔 리다이렉트 사용
	}

}
