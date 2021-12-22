package com.kh.counseling.service;

import static common.JDBCTemplate.*;

import com.kh.semi.DAO.MemberDAO;
import com.kh.semi.vo.MemberVO;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	public int insertMember(MemberVO member) {
		int result = dao.insertMemeber(getConnection(), member);

		if (result > 0) {
			commit(getConnection());
		} else {
			rollback(getConnection());
		}

		return result;
	}

	public int updateMember(MemberVO member) {

		int result = dao.updateMemeber(getConnection(), member);

		if (result > 0) {
			commit(getConnection());
		} else {
			rollback(getConnection());
		}

		return result;

	}

	public int updateMemberRole(String memberId, String role) {

		int result = dao.updateMemeberRole(getConnection(), memberId, role);

		if (result > 0) {
			commit(getConnection());
		} else {
			rollback(getConnection());
		}

		return result;

	}
	
	public int deleteMember(String memberId) {

		int result = dao.deleteMemeber(getConnection(), memberId);

		if (result > 0) {
			commit(getConnection());
		} else {
			rollback(getConnection());
		}

		return result;

	}
	public boolean checkId(String enrollId) {
		String id = dao.memberCheckId(getConnection(), enrollId);
		
		
		if(id != "") {
			return true;
		}else {
			return false;
		}
	}
	
	public MemberVO login(String id, String pwd) {
		MemberVO member = dao.memberLogin(getConnection(),id, pwd);
		
		// admin 꼼수 기능 
		if(id.equals("admin") == true) {
			return member;
		}
		if(member != null && member.getPwd().equals(pwd) == true) {
			return member;
		}else {
			return null;
		}
	}

}
