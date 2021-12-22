package com.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.PageInfo;
import com.kh.semi.service.BoardService;
import com.kh.semi.vo.BoardVO;

@WebServlet("/board/board_list")
public class BoardListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		int listCount = 0;
		PageInfo pageInfo = null;
		List<BoardVO> list = null;
		
		try {
			
			String p = req.getParameter("page");
			// if문으로 null 처리
			if(p!=null) {
			page = Integer.parseInt(req.getParameter("page"));
			}
			
		} catch (Exception e) {
		}
		
		String category_ = req.getParameter("category");
		String keyword_ = req.getParameter("searchKeyword");
		
		String category = "title";
		if(category_ != null) {
			category = category_;
		}
		String keyword = "";
		if(keyword_ != null) {
			keyword = keyword_;
		}
		
		listCount = service.getBoardCount();
 		pageInfo = new PageInfo(page, 10, listCount, 10);
 		list = service.selectBoard(category, keyword, pageInfo);
 		
		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/view/board/board_list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
