package com.kh.semi.board.controller;

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

@WebServlet("/board/board_write")
public class BoardWriteServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession(false);
			MemberVO member = (MemberVO) session.getAttribute("loginMember");
			
			if(member != null) {
				req.getRequestDispatcher("/view/board/board_write.jsp").forward(req, resp);
				return;
			}
			
		} catch (Exception e) {
			
			req.setAttribute("msg", "로그인 후 사용할 수 있습니다.");
			req.setAttribute("location", "/");
	 		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 저장 경로
			String path = getServletContext().getRealPath("/resources/upload");
			
			// 파일 사이즈 - 2MB
			int maxSize = 2097152;
			
			// 인코딩 설정
			String encoding = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new MyFileRenamePolicy());
			String title = mr.getParameter("title");
			String writer = mr.getParameter("writer_no");
			String writer_id = mr.getParameter("writer");
			String content = mr.getParameter("content");
			String file_origin = mr.getOriginalFileName("file");
			String file_rename = mr.getFilesystemName("file");
			
			System.out.println("content : " + content);
			
			if(content == null || content.isEmpty()) {
				content = "";
			}
			
			HttpSession session = req.getSession(false);
			MemberVO member = (MemberVO)session.getAttribute("loginMember");
			
			if(member.getId().equals(writer) == false) {
				sendPage(req, resp);
				return;
			}
			
			BoardVO board = new BoardVO();
			
			board.setTitle(title);
			board.setWriter(writer);
			board.setWriter_id(writer_id);
			board.setContents(content);
			
			if(file_origin != null) {
				board.setFile_origin(file_origin);
				board.setFile_rename(file_rename);
			} else {
				board.setFile_origin("");
				board.setFile_rename("");
			}
		
			int result = service.save(board);
			
			if(result <= 0) {
				sendPage(req, resp);
				return;
			}
			
			req.setAttribute("msg", "게시글이 등록되었습니다.");
			req.setAttribute("location", "/board/board_list");
			
		} catch (Exception e) {
			e.printStackTrace();
			sendPage(req, resp);
		}
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}
	
	private void sendPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("msg", "게시글 등록 실패 했습니다.");
		req.setAttribute("location", "/board/board_list");
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}
}
