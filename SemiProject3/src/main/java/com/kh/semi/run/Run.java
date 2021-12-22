package com.kh.semi.run;

import com.kh.map.service.MapService;
//import com.kh.map.service.MapService;
import com.kh.semi.DAO.EvModelDAO;
import com.kh.semi.DAO.NewsDAO;

public class Run {
	public static void main(String[] args) {
		NewsDAO newsDAO = new NewsDAO();
		newsDAO.passing();
		
//		MapService service = new MapService();
//		service.passingAPI();
		
		//전기차 데이터 입력
//		EvModelDAO evmodel = new EvModelDAO();
//		evmodel.fileRead("전기차 상세정보.csv");
	
}
}