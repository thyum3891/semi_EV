package com.kh.semi.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.DAO.BoardDAO;
import com.kh.semi.service.BoardService;
import com.kh.semi.vo.BoardVO;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public BoardDAO dao = new BoardDAO();
	public BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String board_no = req.getParameter("board_no");
			BoardVO board = service.selectBoardByNo(board_no, false);
			int result = service.delete(board_no);
			
			if(result > 0) {
				req.setAttribute("msg", "게시글이 삭제 되었습니다.");
				
				try {
					String path = getServletContext().getRealPath("/resources/upload");
					File deleteFile = new File(path, board.getFile_rename());
					deleteFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				req.setAttribute("msg", "게시글 삭제 실패했습니다.");
			}
			
		} catch (Exception e) {
			req.setAttribute("msg", "게시글 삭제 실패했습니다");
		}
		req.setAttribute("location", "/board/board_list");
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
		
	}
	
}
