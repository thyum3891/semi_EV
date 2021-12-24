package com.kh.semi.DAO;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.vo.Buy_Counseling;

public class Buy_counselingDAO {

	public List<Buy_Counseling> selectBCAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Buy_Counseling> list = new ArrayList<>();
		String sql = "SELECT * FROM BUY_COUNSELING";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Buy_Counseling bc = new Buy_Counseling();
				bc.setBc_no(rs.getInt("BC_NO"));
				bc.setU_name(rs.getString("U_NAME"));
				bc.setPhone(rs.getString("PHONE"));
				bc.setModelname("MODELNAME");
				bc.setApplication_date(new SimpleDateFormat("yyyy년MM월dd/ EEE").format(rs.getDate("APPLICATION_DATE")));
				bc.setCounseling_date(new SimpleDateFormat("yyyy/MM/dd/ EEE").format(rs.getDate("COUNSELING_DATE")));
				bc.setTime(rs.getString("TIME"));
				bc.setInflow_path("INFLOW_PATH");
				bc.setAdditional_information(rs.getString("ADDITIONAL_INFORMATION"));
				bc.setCheck_counseling(rs.getString("CHECK_COUNSELING"));

				list.add(bc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return list;

	}
	public List<Buy_Counseling> QueryBC(Connection conn, String query, int page) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Buy_Counseling> list = new ArrayList<>();
		String sql ="SELECT * FROM(SELECT ROWNUM NUM ,a.* FROM "
				+ "(SELECT * FROM BUY_COUNSELING where check_counseling LIKE ? ORDER BY counseling_date DESC,  application_date DESC) a"
				+ ") WHERE NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			int startList = ((page-1)*10)+1;
			int endList = page*10;
			pstmt.setInt(2, startList);
			pstmt.setInt(3, endList);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Buy_Counseling bc = new Buy_Counseling();
				bc.setBc_no(rs.getInt("BC_NO"));
				bc.setU_name(rs.getString("U_NAME"));
				bc.setPhone(rs.getString("PHONE"));
				bc.setModelname(rs.getString("MODELNAME"));
				bc.setApplication_date(new SimpleDateFormat("yyyy년 MM월 dd일").format(rs.getDate("APPLICATION_DATE")));
				bc.setCounseling_date(new SimpleDateFormat("yyyy년 MM월 dd일").format(rs.getDate("COUNSELING_DATE")));
				bc.setTime(rs.getString("TIME"));
				bc.setInflow_path(rs.getString("INFLOW_PATH"));
				bc.setAdditional_information(rs.getString("ADDITIONAL_INFORMATION"));
				bc.setCheck_counseling(rs.getString("CHECK_COUNSELING"));
				
				list.add(bc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return list;
		
	}
	public List<Buy_Counseling> QueryBC(Connection conn, String query) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Buy_Counseling> list = new ArrayList<>();
		String sql ="SELECT ROWNUM  ,a.*, c.*  FROM "
				+ "(SELECT * FROM BUY_COUNSELING where check_counseling LIKE ? ORDER BY counseling_date DESC, application_date DESC) a";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Buy_Counseling bc = new Buy_Counseling();
				bc.setBc_no(rs.getInt("BC_NO"));
				bc.setU_name(rs.getString("U_NAME"));
				bc.setPhone(rs.getString("PHONE"));
				bc.setModelname(rs.getString("MODELNAME"));
				bc.setApplication_date(new SimpleDateFormat("yyyy년 MM월 dd일").format(rs.getDate("APPLICATION_DATE")));
				bc.setCounseling_date(new SimpleDateFormat("yyyy년 MM월 dd일").format(rs.getDate("COUNSELING_DATE")));
				bc.setTime(rs.getString("TIME"));
				bc.setInflow_path(rs.getString("INFLOW_PATH"));
				bc.setAdditional_information(rs.getString("ADDITIONAL_INFORMATION"));
				bc.setCheck_counseling(rs.getString("CHECK_COUNSELING"));
				
				list.add(bc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return list;
		
	}
	public int CountBC(Connection conn, String query) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT count(*) FROM BUY_COUNSELING where check_counseling LIKE ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return result;
		
	}

	public int deleteBC(Connection conn, int bc_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM BUY_COUNSELING WHERE BC_NO = ?";
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc_no);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return result;

	}

	
	
	public int insertBC(Connection conn, Buy_Counseling bc) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO BUY_COUNSELING VALUES(SEQ_BCNO.NEXTVAL, ?, ?, ?, sysdate, TO_DATE(?),?, ?, ?, DEFAULT)";
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bc.getU_name());
			pstmt.setString(2, bc.getPhone());
			pstmt.setString(3, bc.getModelname());
			pstmt.setString(4, bc.getCounseling_date());
			pstmt.setString(5, bc.getTime());
			pstmt.setString(6, bc.getInflow_path());
			pstmt.setString(7, bc.getAdditional_information());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return result;

	}
	
	public int checkBC(Connection conn, int bc_no, String Query) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE BUY_COUNSELING SET CHECK_COUNSELING = ? WHERE BC_NO = ?";
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Query);
			pstmt.setInt(2, bc_no);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return result;

	}
	
	public List<Buy_Counseling> selectBCOne(Connection conn, String test) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Buy_Counseling> list = new ArrayList<>();
		String sql = "SELECT * FROM BUY_COUNSELING where U_NAME = 'ADMIN'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Buy_Counseling bc = new Buy_Counseling();
				bc.setBc_no(rs.getInt("BC_NO"));
				bc.setU_name(rs.getString("U_NAME"));
				bc.setPhone(rs.getString("PHONE"));
				bc.setModelname(rs.getString("MODELNAME"));
				bc.setApplication_date(rs.getString("APPLICATION_DATE"));
				bc.setCounseling_date(rs.getString("COUNSELING_DATE"));
				bc.setTime(rs.getString("TIME"));
				bc.setInflow_path(rs.getString("INFLOW_PATH"));
				bc.setAdditional_information(rs.getString("ADDITIONAL_INFORMATION"));
				bc.setCheck_counseling(rs.getString("CHECK_COUNSELING"));

				list.add(bc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return list;

	}
	
	
}
