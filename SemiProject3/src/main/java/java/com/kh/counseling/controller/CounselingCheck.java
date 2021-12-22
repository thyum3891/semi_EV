package com.kh.counseling.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.counseling.service.Buy_CounselingService;

@WebServlet("/counseling/check")
public class CounselingCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Buy_CounselingService service = new Buy_CounselingService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String value = req.getParameter("value");
			int bc_no = Integer.parseInt(req.getParameter("bc_no"));
			
			if(value.equals("미확인")) {
				service.checkBC(bc_no, "확인 완료");
			}else {
				service.checkBC(bc_no, "미확인");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
