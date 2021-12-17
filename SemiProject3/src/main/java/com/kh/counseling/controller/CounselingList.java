package com.kh.counseling.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.counseling.service.Buy_CounselingService;
import com.kh.semi.vo.Buy_Counseling;

@WebServlet("/counseling/list/inner")
public class CounselingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Buy_CounselingService service = new Buy_CounselingService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int p = 1;
			String page = req.getParameter("page");
			if(page!=null && !page.equals("")) {
				p = Integer.parseInt(page);
			}
			int count = service.countBC();
			List<Buy_Counseling> list = service.QueryAllBC(p);
			req.setAttribute("bcList", list);
			req.setAttribute("page", p);
			req.setAttribute("count", count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		req.getRequestDispatcher("/view/counseling/counselingList.jsp").forward(req, resp);
		
	}
}
