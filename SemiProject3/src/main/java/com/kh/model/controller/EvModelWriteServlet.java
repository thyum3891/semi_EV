package com.kh.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.util.MyFileRenamePolicy;
import com.kh.model.service.EvModelService;
import com.kh.semi.vo.EvModelVO;
import com.kh.semi.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/model/write")
public class EvModelWriteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EvModelService service = new EvModelService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession(false);
			MemberVO member = (MemberVO) session.getAttribute("loginMember");
			if(member != null) {
				req.getRequestDispatcher("/view/model/write.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {}
		
		// 비정상적 흐름
		req.setAttribute("msg", "로그인 후 사용할 수 있습니다.");
		req.setAttribute("location", "/");
 		req.getRequestDispatcher("/view/common/msg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String path = getServletContext().getRealPath("/resources/image");
			int maxSize = 1024*1024*50; //50MB
			String encoding = "UTF-8";
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encoding, new MyFileRenamePolicy());
			
			EvModelVO model = new EvModelVO();
			
			String name = mr.getParameter("blogContactsModelName");
			model.setModelName(name);
			model.setModelSub(mr.getParameter("blogContactsModelSub"));
			model.setPrice(Integer.parseInt(mr.getParameter("blogContactsPrice")));
			model.setFuel(mr.getParameter("blogContactsFuel"));
			model.setPerson(mr.getParameter("blogContactsPerson"));
			model.setDrive(mr.getParameter("blogContactsDrive"));
			model.setTransM(mr.getParameter("blogContactsTransM"));
			model.setDistance(mr.getParameter("blogContactsDistance"));
			model.setEnergy(mr.getParameter("blogContactsEnergy"));
			model.setMotor(mr.getParameter("blogContactsMotor"));
			model.setCompany(mr.getParameter("blogContactsCompany"));
			model.setNation(mr.getParameter("blogContactsNation"));
			model.setImage_1(mr.getFilesystemName("image1"));
			model.setImage_2(mr.getFilesystemName("image2"));
			model.setImage_3(mr.getFilesystemName("image3"));
			model.setImage_4(mr.getFilesystemName("image4"));
			model.setImage_5(mr.getFilesystemName("image5"));	    
			
			System.out.println(model.toString());
			
			int result = service.save(model);
			
			if(result <= 0) {
				sendErrorPage(req, resp);
				return;
			}
			req.setAttribute("msg", "게시글이 등록 되었습니다.");
			req.setAttribute("location", "");
			req.getRequestDispatcher("/view/common/msg.jsp").forward(req, resp);			
		} catch (Exception e) {
			e.printStackTrace();
			sendErrorPage(req, resp);
		}
		
	}
	
	private void sendErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", "게시글 등록에 실패 했습니다.");
		req.setAttribute("location", "/board/list");
		req.getRequestDispatcher("/views/common/msg.jsp").forward(req, resp);
	}
}