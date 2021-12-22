package com.kh.semi.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.util.MyFileRenamePolicy;
import com.kh.semi.service.BoardService;
import com.kh.semi.vo.BoardVO;
import com.kh.semi.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/board/board_update")
public class BoardUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String board_no = req.getParameter("board_no");
		BoardVO board = service.selectBoardByNo(board_no, true);
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/view/board/board_update.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 저장 경로 지정
			String path = getServletContext().getRealPath("/resources/upload");
			
			// 파일 사이즈 - 2MB
			int maxSize = 2097152;
			
			// 인코딩 설정
			String encoding = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new MyFileRenamePolicy());
			
			String board_no = mr.getParameter("board_no");
			String title = mr.getParameter("title");
			String writer = mr.getParameter("writer");
			String writer_no = mr.getParameter("writer_no");
			String content = mr.getParameter("content");
			String file_origin = mr.getParameter("file_origin");
			String file_rename = mr.getParameter("file_rename");
			
			String reload_origin = mr.getOriginalFileName("reloadFile");
			String reload_rename = mr.getFilesystemName("reloadFile");
			
			if(reload_origin != null && reload_origin.length() > 0) {
				try {
					
					File deleteFile = new File(path, file_rename);
					deleteFile.delete();
					
					file_origin = reload_origin;
					file_rename = reload_rename;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			HttpSession session = req.getSession(false);
			MemberVO member = (MemberVO)session.getAttribute("loginMember");
			
			if(member.getId().equals(writer) == false) {
				req.setAttribute("msg", "아이디가 다릅니다 다시 확인해 주세요.");
				return;
			}
			
			BoardVO board = new BoardVO();
			
			board.setBoard_no(board_no);
			board.setTitle(title);
			board.setWriter_id(writer);
			board.setWriter(writer_no);
			board.setContents(content);
			
			if(file_origin != null) {
				board.setFile_origin(file_origin);
				board.setFile_rename(file_rename);
			} else {
				board.setFile_origin("");
				board.setFile_rename("");
			}
			
			int result = service.updateBoard(board);
			
			if(result > 0 ) {
				req.setAttribute("msg", "게시글이 수정되었습니다.");
				req.setAttribute("location", "/board/board_view?board_no=" + board.getBoard_no());
				req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			req.setAttribute("msg", "게시글 수정 실패 했습니다.");
			req.setAttribute("location", "/board/board_list");
			req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
		}
	
	}
}
