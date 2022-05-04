package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class RecipeDetailService implements IRecipeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strPostID = request.getParameter("postID");
		
		int postID = Integer.parseInt(strPostID);
		
		BoardDAO bdao = BoardDAO.getInstance();
		
		BoardVO board = bdao.getBoardDetail(postID);
		
		ComDAO cdao = ComDAO.getInstance();

        List<ComVO> ComList = cdao.getComList(postID);
        request.setAttribute("ComList", ComList);
		
		request.setAttribute("board", board);
		
	}

}
