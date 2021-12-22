package com.kh.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.service.BoardService;
import com.kh.semi.vo.MemberVO;
import com.kh.semi.vo.ReplyVO;

@WebServlet("/board/reply")
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService service = new BoardService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String board_no = req.getParameter("board_no");
			String writer = req.getParameter("replyWriter");
			String content = req.getParameter("replyContent");
			
			System.out.println("writer :" + writer);
			System.out.println("board_no :" + board_no);
			System.out.println("content :" + content);
			
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("loginMember");

			if (member.getId().equals(writer)) { // 아이디 일치
				
				ReplyVO reply = new ReplyVO();
				
				reply.setBoard_reply_no(board_no);
				reply.setWriter_id(writer);
				reply.setContents(content);
				int result = service.saveReply(reply);

				if (result <= 0) { // 등록 실패 했을 때
					sendCommonPage("댓글 등록 실패", ("/board/board_view?board_no=" + board_no), req, resp);
					return;
				}
			} else { // 아이디 불일치
				sendCommonPage("아이디가 다릅니다. 다시 확인해 주세요", "/", req, resp);
				return;
			}
			
			sendCommonPage("댓글 등록 성공", ("/board/board_view?board_no=" + board_no), req, resp);
			
		} catch (Exception e) {
			sendCommonPage("잘못된 접근 입니다.", "/", req, resp);
			return;
		}
	}
	
	void sendCommonPage(String msg, String path, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("msg", msg);
		req.setAttribute("location", path);
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}
}
