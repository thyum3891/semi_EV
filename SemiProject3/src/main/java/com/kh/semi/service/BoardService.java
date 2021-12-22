package com.kh.semi.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.common.util.PageInfo;
import com.kh.semi.DAO.BoardDAO;
import com.kh.semi.vo.BoardVO;
import com.kh.semi.vo.ReplyVO;

public class BoardService {
	private BoardDAO dao = new BoardDAO();

	public BoardVO selectBoardByNo(String board_no, boolean hasRead) {
		Connection conn = getConnection();
		BoardVO board = dao.selectBoardByNo(conn, board_no);
		
		if(hasRead == true && board != null) {
			int result = dao.updateReadCount(conn, board);
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);
		return board;
	}
	
	public List<BoardVO> selectBoard(String category,String keyword, PageInfo pageInfo) {
		
		Connection conn = getConnection();
		List<BoardVO> list = dao.selectBoard(conn, category, keyword, pageInfo);
		close(conn);
		return list;
	}
	
	public int save(BoardVO board) {
		Connection conn = getConnection();
		int result = 0;
		
		if(board.getBoard_no() != null) {
			result = dao.updateBoard(conn, board);
		} else {
			result = dao.insertBoard(conn, board);
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		System.out.println(result);
		
		return result;
	}
	
	public int saveReply(ReplyVO reply) {
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.insertReply(conn, reply);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteReply(String reply_no) {
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, reply_no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int updateBoard(BoardVO board) {
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.updateBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int getBoardCount() {
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.getBoardCount(conn);
		
		close(conn);
		
		return result;
	}
	
	public int delete(String board_no) {
		Connection conn = getConnection();
		int result;
		
		result = dao.deleteBoard(conn, board_no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	
}
