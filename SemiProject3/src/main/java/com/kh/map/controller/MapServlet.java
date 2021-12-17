package com.kh.map.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.map.service.MapService;

@WebServlet("/map")
public class MapServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static MapService service = new MapService();
//	private static Map<String,Map<String,String>> staticMap = service.selectAllMap();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			 
			
//			String add2 = req.getParameter("add2");
			String lat = req.getParameter("lat");
			String lng = req. getParameter("lon");
			List<Map<String,String>> locationMapList = service.selectDetailAll(lat,lng);
			req.setAttribute("lat", lat);
			req.setAttribute("lng", lng);
			req.setAttribute("locationMapList", locationMapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		req.getRequestDispatcher("/view/map.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	doGet(req, resp);
	}
	
}
