package com.kh.semi.DAO;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.vo.MemberVO;



public class MemberDAO {
	
	//SELLECT
	public List<MemberVO> sellectAll(Connection conn){
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			MemberVO member = new MemberVO();
			member.setId(rs.getString("ID"));
			member.setName(rs.getString("NAME"));
			member.setPhone(rs.getString("PHONE"));
			member.setRole(rs.getString("ROLE"));
			member.setEnroll_date(rs.getDate("ENROLL_DATE"));
			
			memberList.add(member);
			}
			
		} catch (Exception e) {
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return memberList;
		
	}
	public MemberVO memberLogin(Connection conn, String id, String pwd){
		
		MemberVO member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE ID = ? AND PWD = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("ID"));
				member.setPwd(rs.getString("PWD"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setRole(rs.getString("ROLE"));
				member.setEnroll_date(rs.getDate("ENROLL_DATE"));
				
				
				
			}
			
		} catch (Exception e) {
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		if(member.getId() == null) {
			return null;
		}
		return member;
		
	}
	public String memberCheckId(Connection conn, String id){
		
		String memberId = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE ID = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberId = rs.getString("ID");
								
			}
			
		} catch (Exception e) {
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return memberId;
		
	}
	
	// INSERT
	public int insertMemeber(Connection conn, MemberVO member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL, ?, ?, DEFAULT, ?, ?, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	//update
	public int updateMemeber(Connection conn, MemberVO member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET NAME = ?, PWD = ?, PHONE = ? WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	public int updateMemeberRole(Connection conn, String memberId, String role) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET ROLE = ? WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, role);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	//delete
	public int deleteMemeber(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	
	

}
