package com.kh.semi.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/fileDown")
public class BoardFileDownServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String file_origin = req.getParameter("oriname");
		String file_rename = req.getParameter("rename");
		
		String path = getServletContext().getRealPath("/resources/upload");
		File downFile = new File(path, file_rename);
		
		FileInputStream fis = new FileInputStream(downFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		String header = req.getHeader("user-agent");
		boolean isMSIE = header.contains("MSIE") || header.contains("Trident");
		String downName = null;
		
		if (isMSIE) {
    		downName = URLEncoder.encode(file_origin, "UTF-8").replaceAll("\\+", "%20");
    	} else {    		
    		downName = new String(file_origin.getBytes("UTF-8"), "ISO-8859-1");
    	}
		
		resp.setContentType("application/octec-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=" + downName);
		
		int read = 0;
		while((read = bis.read()) != -1) {
			bos.write(read);
		}
		
		bis.close();
		bos.close();
		
	}
}
