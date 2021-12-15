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
		boolean isDupl  = service.checkId(userId);
		
		if(isDupl == true) {
			// 중복
			resp.getWriter().append("중복");
		}else {
			// 중복 아님
			resp.getWriter().append("중복아님");
		}
	}
	
}
