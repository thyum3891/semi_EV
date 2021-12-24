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

@WebServlet("/mapQ")
public class MapServletQ extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static MapService service = new MapService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String lat = req.getParameter("lat");
			String lng = req. getParameter("lon");
			String Qvalue = req.getParameter("value");
			
			String setLat = "";
			String setLon = "";
			if(Qvalue.equals("강남구")){
		    	 setLat =  "37.4951";
		    	 setLon = "127.06278";
		    }else if(Qvalue.equals("강동구")) {
		    	 setLat =  "37.53246";
		    	 setLon = "127.1237";	   
		    }else if(Qvalue.equals("강북구")) {
		    	 setLat =  "37.55274";
		    	 setLon = "127.14546";	   
		    }else if(Qvalue.equals("강서구")) {
		    	 setLat =  "37.56227";
		    	 setLon = "126.81622";	   
		    }else if(Qvalue.equals("관악구")) {
		    	 setLat =  "37.47876";
		    	 setLon = "126.95235";	   
		    }else if(Qvalue.equals("광진구")) {
		    	 setLat =  "37.53913";
		    	 setLon = "127.08366";	   
		    }else if(Qvalue.equals("구로구")) {
		    	 setLat = "37.49447";
		    	 setLon = "126.8502";	   
		    }else if(Qvalue.equals("금천구")) {
		    	 setLat = "37.47486";
		    	 setLon = "126.89106";	   
		    }else if(Qvalue.equals("노원구")) {
		    	 setLat =  "37.66045";
		    	 setLon = "127.06718";	   
		    }else if(Qvalue.equals("도봉구")) {
		    	 setLat =  "37.65066";
		    	 setLon = "127.03011";	   
		    }else if(Qvalue.equals("동대문구")) {
		    	 setLat =  "37.58189";
		    	 setLon = "127.05408";	   
		    }else if(Qvalue.equals("동작구")) {
		    	 setLat =  "37.50056";
		    	 setLon = "126.95149";	   
		    }else if(Qvalue.equals("마포구")) {
		    	 setLat =  "37.55438";
		    	 setLon = "126.90926";	   
		    }else if(Qvalue.equals("서대문구")) {
		    	 setLat =  "37.57809";
		    	 setLon = "126.93506";	   
		    }else if(Qvalue.equals("서초구")) {
		    	 setLat =  "37.49447";
		    	 setLon = "127.01088";	   
		    }else if(Qvalue.equals("성동구")) {
		    	 setLat =  "37.54784";
		    	 setLon = "127.02461";	   
		    }else if(Qvalue.equals("성북구")) {
		    	 setLat =  "37.60267";
		    	 setLon = "127.01448";	   
		    }else if(Qvalue.equals("송파구")) {
		    	 setLat =  "37.5021";
		    	 setLon = "127.11113";	   
		    }else if(Qvalue.equals("양천구")) {
		    	 setLat =  "37.52056";
		    	 setLon = "126.87472";	   
		    }else if(Qvalue.equals("영등포구")) {
		    	 setLat =  "37.52606";
		    	 setLon = "126.90308";	   
		    }else if(Qvalue.equals("용산구")) {
		    	 setLat =  "37.53391";
		    	 setLon = "126.9775";	   
		    }else if(Qvalue.equals("은평구")) {
		    	 setLat =  "37.61846";
		    	 setLon = "126.9278";	   
		    }else if(Qvalue.equals("종로구")) {
		    	 setLat =  "37.5729";
		    	 setLon = "126.97928";	   
		    }else if(Qvalue.equals("중구")) {
		    	 setLat =  "37.55986";
		    	 setLon = "126.99398";	   
		    }else if(Qvalue.equals("중랑구")) {
		    	 setLat =  "37.60199";
		    	 setLon = "127.10461";	   
		    }else {
		    	Qvalue = "";
		    	 setLat = lat;
		    	 setLon = lng;
		    }
			List<Map<String,String>> locationMapList = service.selectDetailQuery(lat,lng,Qvalue);
			req.setAttribute("setLat", setLat);
			req.setAttribute("setLng", setLon);
			req.setAttribute("lat", lat);
			req.setAttribute("lng", lng);
			req.setAttribute("locationMapList", locationMapList);
		} catch (Exception e) {
		}

			req.getRequestDispatcher("/view/map.jsp").forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
	
}
