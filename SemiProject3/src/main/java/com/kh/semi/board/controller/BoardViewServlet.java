package com.kh.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.service.BoardService;
import com.kh.semi.vo.BoardVO;

@WebServlet("/board/board_view")
public class BoardViewServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String board_no = req.getParameter("board_no");
			BoardVO board = service.selectBoardByNo(board_no, true);
			
			if(board == null) {
				resp.sendRedirect(req.getContextPath());
				return;
			}else {
				req.setAttribute("board", board);
				req.getRequestDispatcher("/view/board/board_view.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
