package com.kh.counseling.controller;

import static common.JDBCTemplate.*;


import java.util.List;

import com.kh.semi.DAO.Buy_counselingDAO;
import com.kh.semi.vo.Buy_Counseling;

public class Buy_CounselingService {
	
	Buy_counselingDAO dao = new Buy_counselingDAO();
	
	public List<Buy_Counseling> selectBCAll(){
		return dao.selectBCAll(getConnection());
	}
	
	public int checkBC(int bc_no, String query) {
		
		int result = dao.checkBC(getConnection(), bc_no, query);
		
		if(result>0) {
			commit(getConnection());
		}else {
			rollback(getConnection());
		}
		
		return result;
		
	}
	public int deleteBC(int bc_no) {
		
		int result = dao.deleteBC(getConnection(), bc_no);
		
		if(result>0) {
			commit(getConnection());
		}else {
			rollback(getConnection());
		}
		
		return result;
		
	}
	
	public int countBC() {
		int result = dao.CountBC(getConnection(), "");
		return result;
		
	}
	
}
