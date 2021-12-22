package com.kh.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.service.EvModelService;

@WebServlet("/model/updateReadCount")
public class EvModelReadCountServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EvModelService service = new EvModelService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("Params");
		
		String temp[];		
		temp = id.split(",");
		
		String modelName = temp[0];
		String modelSub = temp[1];		
//		System.out.println(modelName);
//		System.out.println(modelSub);
		
		int result = service.findEvModelNo(modelName, modelSub, true);
		if (result>0) {
			System.out.println("조회수 증가 성공");
		} else {
			System.out.println("조회수 증가 실패");
		}
	}
}
