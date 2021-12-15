package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.map.service.MemberService;
import com.kh.semi.vo.MemberVO;

@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	MemberService service = new MemberService();
	
	private static final String MEMBER_ID = "userId";
	private static final String MEMBER_PWD1 = "pass1";
	private static final String MEMBER_PWD2 = "pass2";
	private static final String MEMBER_NAME = "name";
	private static final String MEMBER_PHONE = "phone";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession();
		MemberVO member = new MemberVO();
		//로그인할 시 세션 생성시켜서 받기
//		String loginId = session.getAttribute("loginId");
		try {
			String id = req.getParameter(MEMBER_ID);
			if(id.contains("@")==false) {
				req.setAttribute("msg", "아이디가 이메일 형식이 아닙니다.");
				req.setAttribute("location", req.getContextPath());
				req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
			}
			String pwd1 = req.getParameter(MEMBER_PWD1);
			String pwd2 = req.getParameter(MEMBER_PWD2);
			if(pwd1.equals(pwd2)==false) {
				req.setAttribute("msg", "비밀번호가 달라 회원가입에 실패하였습니다.");
				req.setAttribute("location", "");
				req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
			}
			String name = req.getParameter(MEMBER_NAME);
			String phone = req.getParameter(MEMBER_PHONE);
			
			member.setId(id);
			member.setPwd(pwd1);
			member.setName(name);
			member.setPhone(phone);
			
			int result = service.insertMember(member);
			
			if(result > 0) {
				req.setAttribute("msg", "회원가입 성공");
				req.setAttribute("location", req.getContextPath());
			}else {
				req.setAttribute("msg", "회원가입 실패");
				req.setAttribute("location", req.getContextPath());
			}
			
			
			
		} catch (Exception e) {
			req.setAttribute("msg", "회원가입 실패");
			req.setAttribute("location", req.getContextPath());
		}
		
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
		
		
		
		
		
		
	
	}
	

	
}
