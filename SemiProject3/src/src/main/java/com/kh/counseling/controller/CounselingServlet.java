package com.kh.counseling.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.vo.MemberVO;

@WebServlet("/counseling/request")
public class CounselingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		try {
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO) session.getAttribute("loginMember");
			if (member == null) {
				sendMsgPage(req, resp, "로그인이 필요합니다.", "");
				return;
			}

			String carModelName = req.getParameter("modelname");

			req.setAttribute("modelName", carModelName);
			req.setAttribute("name", member.getName());
			req.setAttribute("phone", member.getPhone());

			req.getRequestDispatcher("/view/counseling/counselingForm.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void sendMsgPage(HttpServletRequest req, HttpServletResponse resp, String msg, String location)
			throws ServletException, IOException {
		req.setAttribute("msg", msg);
		req.setAttribute("location", location);
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}

}
