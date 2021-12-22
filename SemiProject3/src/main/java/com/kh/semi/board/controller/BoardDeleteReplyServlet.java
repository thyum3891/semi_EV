package com.kh.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.service.BoardService;

@WebServlet("/board/replyDelete")
public class BoardDeleteReplyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private BoardService service = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reply_no = req.getParameter("reply_no");
		
		try {
			int result = service.deleteReply(reply_no);
			
			if(result > 0) {
				req.setAttribute("msg", "댓글 삭제 성공!");
			} else {
				req.setAttribute("msg", "댓글 삭제 실패..");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "댓글 삭제 실패..");
		}
		
		req.setAttribute("location", ("/board/board_list"));
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}
}
