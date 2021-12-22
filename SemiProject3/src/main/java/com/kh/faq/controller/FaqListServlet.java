package com.kh.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.faq.service.FaqService;
import com.kh.semi.vo.Faq;

@WebServlet("/faqList.do")
public class FaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FaqService service = new FaqService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Faq> list = service.getFaqList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/view/faq.jsp").forward(req, resp);
	}
	
}
