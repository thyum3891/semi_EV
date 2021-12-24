package com.kh.counseling.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.counseling.service.Buy_CounselingService;
import com.kh.semi.vo.Buy_Counseling;

@WebServlet("/counseling/save")
public class CounselingSave extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Buy_CounselingService service = new Buy_CounselingService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Buy_Counseling bc = new Buy_Counseling();
			
			bc.setU_name(req.getParameter("name"));
			bc.setPhone(req.getParameter("phone"));
			bc.setTime(req.getParameter("time"));
			bc.setCounseling_date(req.getParameter("date"));
			bc.setInflow_path(req.getParameter("inflowPath"));
			bc.setModelname(req.getParameter("modelName"));
			bc.setAdditional_information(req.getParameter("additionalInfoCareersFormName"));
			
			int result = service.insertBC(bc);
			
			if(result>=0) {
				sendMsgPage(req, resp, "예약 완료", "");
			}else {
				sendMsgPage(req, resp, "예약 중 문제가 발생하였습니다.\n 다시 시도해주세요.", "");
			}
		} catch (Exception e) {
			sendMsgPage(req, resp, "예약 중 문제가 발생하였습니다.\n 다시 시도해주세요.", "");
		}
		
		
		
		

		
	
	}
	
	private void sendMsgPage(HttpServletRequest req, HttpServletResponse resp, String msg, String location)
			throws ServletException, IOException {
		req.setAttribute("msg", msg);
		req.setAttribute("location", location);
		req.getRequestDispatcher("/common/msg.jsp").forward(req, resp);
	}

}
