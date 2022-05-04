package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComListService implements IComService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ComDAO dao = ComDAO.getInstance();
		String postid = "1";
		int postID = Integer.parseInt(postid);
		List<ComVO> ComList = dao.getComList(postID);
		request.setAttribute("ComList", ComList);
	}

}
