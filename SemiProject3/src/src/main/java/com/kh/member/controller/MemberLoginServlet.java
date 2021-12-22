package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.map.service.MemberService;
import com.kh.semi.vo.MemberVO;


@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		System.out.println(userID+","+userPwd);
		
		MemberVO loginMember = service.login(userID, userPwd);
		
		if(loginMember != null ) { 
			HttpSession session =  req.getSession();
			session.setAttribute("loginMember", loginMember);

			resp.sendRedirect(req.getContextPath()+"/"); 
		}else { 
			
			req.setAttribute("msg", "사용자 아이디나 비밀번호가 맞지 않습니다!");
			req.setAttribute("location", "");
			
			req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
		}
	}
}






