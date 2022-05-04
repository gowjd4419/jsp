package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComDetailService implements IComService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ComDAO dao = ComDAO.getInstance();
		String commentid = request.getParameter("commentID");
		int commentID = Integer.parseInt(commentid); 
		ComVO com = dao.getComDetail(commentID);
		
		request.setAttribute("com", com);
	}

}
