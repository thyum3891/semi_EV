package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.map.service.MemberService;

@WebServlet("/member/checkId2")
public class MemberCheckIdServletForAJAX extends HttpServlet{
	private static final long serialVersionUID = 1L;

	MemberService service = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid");
		System.out.println("userId : " + userId);
		if(userId.contains("@")==false) {
			resp.getWriter().append("이메일형식의 아이디가 아닙니다.");
			return;
		}
		boolean isDupl  = service.checkId(userId);
		
		if(isDupl == true) {
			// 중복
			resp.getWriter().append("중복된 아이디입니다.");
		}else {
			// 중복 아님
			resp.getWriter().append("사용가능한 아이디입니다.");
		}
	}
	
}
