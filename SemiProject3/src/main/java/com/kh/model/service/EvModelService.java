package com.kh.model.service;

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
	
	public int getModel(){
		
		Connection conn = getConnection();
		int count = dao.selectEv(conn);
		close(conn);
		return count;
	}
	
	public List<EvModelVO> getModel(PageInfo pageInfo){
		
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEv(conn,pageInfo);
		close(conn);
		return list;
	}
	
	public List<EvModelVO> getModelhPrice(PageInfo pageInfo){
		
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEvhPrice(conn,pageInfo);
		close(conn);
		return list;
	}
	
	public List<EvModelVO> getModelrPrice(PageInfo pageInfo){
		
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEvrPrice(conn,pageInfo);
		close(conn);
		return list;
	}
	
	public List<EvModelVO> getModelSearch(PageInfo pageInfo, String keyword) {
		Connection conn = getConnection();
		List<EvModelVO> list = dao.selectEvSearch(conn,pageInfo,keyword);
		close(conn);
		return list;
	}
	
	public int findEvModelNo(String modelName,String modelSub, boolean hasRead) {
		
		Connection conn = getConnection();
		EvModelVO evmodel = dao.findEvModelNo(conn,modelName,modelSub);
		int result = 0;
		
		// 조회수 증가 로직 추가
		if(hasRead == true && evmodel !=null) {
			result = dao.updateReadCount(conn, evmodel);
			System.out.println(evmodel.getReadcount());
			if(result > 0 ) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return result;
	}

	

}
