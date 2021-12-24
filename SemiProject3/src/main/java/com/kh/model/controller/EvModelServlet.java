package com.kh.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.PageInfo;
import com.kh.model.service.EvModelService;
import com.kh.semi.vo.EvModelVO;

@WebServlet("/model/view")
public class EvModelServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	EvModelService service = new EvModelService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page = 1;
		int listCount = 0;
		PageInfo pageInfo = null;
		List<EvModelVO> list = null;
		
		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {}
		
		listCount = service.getModel(); //전기차 데이터 count		
		pageInfo = new PageInfo(page, 10, listCount, 12); //페이징
		list = service.getModel(pageInfo); //페이징에 따른 데이터 추출
//		System.out.println(list);
		
		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/view/model/modelList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
