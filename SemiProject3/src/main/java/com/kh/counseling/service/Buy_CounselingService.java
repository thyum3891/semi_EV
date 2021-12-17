package com.kh.counseling.service;

import static common.JDBCTemplate.*;

import java.util.List;

import com.kh.semi.DAO.Buy_counselingDAO;
import com.kh.semi.vo.Buy_Counseling;

public class Buy_CounselingService {
	
	Buy_counselingDAO dao = new Buy_counselingDAO();
	
	public List<Buy_Counseling> selectBCAll(){
		return dao.selectBCAll(getConnection());
	}
	
	public int checkBC(int bc_no, String Query) {
		
		int result = dao.checkBC(getConnection(), bc_no, Query);
		close(getConnection());
		if(result>0) {
			commit(getConnection());
		}else {
			rollback(getConnection());
		}
		
		return result;
		
	}
	public int deleteBC(int bc_no) {
		
		int result = dao.deleteBC(getConnection(), bc_no);
		close(getConnection());
		if(result>0) {
			commit(getConnection());
		}else {
			rollback(getConnection());
		}
		
		return result;
		
	}
	
	public int insertBC(Buy_Counseling bc) {
		int result = dao.insertBC(getConnection(), bc);
		close(getConnection());
		if(result > 0) {
			commit(getConnection());
		}else {
			rollback(getConnection());
		}
		
		return result;
	}
	public List<Buy_Counseling> QueryAllBC(int page){
		List<Buy_Counseling> list = dao.QueryBC(getConnection(),"",page);
		close(getConnection());
		
		return list; 
		
	}
	public List<Buy_Counseling> QueryCheckBC(int page){
		
		List<Buy_Counseling> list = dao.QueryBC(getConnection(),"확인 완료",page);
		close(getConnection());
		
		return list; 
		
		
	}
	public List<Buy_Counseling> QueryNoCheckBC(int page){
		
		List<Buy_Counseling> list = dao.QueryBC(getConnection(),"미확인",page);
		close(getConnection());
		
		return list; 
		
		
	}
	public int countBC() {
		
		int count = dao.CountBC(getConnection(), "");
		return count;
	}
	
	
}
