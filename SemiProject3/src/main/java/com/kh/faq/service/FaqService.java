package com.kh.faq.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.DAO.FaqDAO;
import com.kh.semi.vo.Faq;

public class FaqService {
	private FaqDAO dao = new FaqDAO();
	
	
	public List<Faq> getFaqList(){
		Connection connection = getConnection();
		List<Faq> list = dao.selectAll(connection);
		close(connection);
		return list;
	}
	
}
