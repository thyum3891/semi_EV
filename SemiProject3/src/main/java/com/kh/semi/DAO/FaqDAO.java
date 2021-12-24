package com.kh.semi.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;
import com.kh.semi.vo.Faq;

public class FaqDAO {

	// FAQ 가져오기
	public List<Faq> selectAll(Connection connection){
		List<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT TITLE, CONTENTS FROM FAQ";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			 
			while(rs.next()) {
				Faq faq = new Faq();
				faq.setTitle(rs.getString("TITLE"));
				faq.setContents(rs.getString("CONTENTS"));
				list.add(faq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(connection);
		}
		return list;
	}
	
}
