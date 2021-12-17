package com.kh.model.service;

//
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.common.util.PageInfo;
import com.kh.semi.DAO.EvModelDAO;
import com.kh.semi.vo.EvModelVO;

public class EvModelService {
	
	private EvModelDAO dao = new EvModelDAO();
	
	public int save(EvModelVO evModelVO) {
		
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.insertEvModel(conn,evModelVO);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}

		close(conn);
		
		return result;	
		
	}
	
	public List<EvModelVO> getModel(){
		
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEv(conn);
		close(conn);
		return list;
	}
	
	public List<EvModelVO> getModel(PageInfo pageInfo){
		
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEv(conn,pageInfo);
		close(conn);
		return list;
	}

}
