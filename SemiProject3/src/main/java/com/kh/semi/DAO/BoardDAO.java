package com.kh.semi.DAO;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.util.PageInfo;
import com.kh.semi.vo.BoardVO;
import com.kh.semi.vo.ReplyVO;

public class BoardDAO {
	
	// 게시물 개수 확인
	public int getBoardCount(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String query = "SELECT COUNT(*) FROM BOARD";
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return result;
	}
	
	// SELECT - 게시물 리스트 조회
	public List<BoardVO> selectBoard(Connection conn, String category, String keyword, PageInfo pageInfo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		
		String query = "SELECT RNUM, BOARD_NO, TITLE, ID, CREATE_DATE, FILE_ORIGIN, READCOUNT "
				+ "FROM ("
				+ "    SELECT ROWNUM AS RNUM, BOARD_NO, TITLE, ID, CREATE_DATE, FILE_ORIGIN, READCOUNT "
				+ "    FROM ("
				+ "        SELECT B.BOARD_NO, B.TITLE, M.ID, B.CREATE_DATE, B.FILE_ORIGIN, B.READCOUNT "
				+ "        FROM BOARD B JOIN MEMBER M ON(B.WRITER = M.ID) "
				+ "		   ORDER BY BOARD_NO DESC "
				+ "    )"
				+ "    BOARD WHERE " + category + " LIKE '%" + keyword +"%'"
				+ ")"
				+ "WHERE RNUM BETWEEN ? AND ?";
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, pageInfo.getStartList());
			ps.setInt(2, pageInfo.getEndList());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setRowNum(rs.getInt("RNUM"));
				board.setBoard_no(rs.getString("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter_id(rs.getString("ID"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setFile_origin(rs.getString("FILE_ORIGIN"));
				board.setReadcount(rs.getInt("READCOUNT"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return list;
	}
	
	// SELECT - 게시판 상세 조회
	public BoardVO selectBoardByNo(Connection conn, String board_no) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT B.BOARD_NO, B.TITLE, M.ID, B.READCOUNT, B.FILE_ORIGIN, B.FILE_RENAME, B.CONTENTS, B.CREATE_DATE, B.MODIFY_DATE "
				+ "FROM BOARD B "
				+ "JOIN MEMBER M ON(B.WRITER = M.ID) "
				+ "WHERE B.BOARD_NO=?";
		BoardVO board = new BoardVO();
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, board_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				board.setBoard_no(rs.getString("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter_id(rs.getString("ID"));
				board.setReadcount(rs.getInt("READCOUNT"));
				board.setFile_origin(rs.getString("FILE_ORIGIN"));
				board.setFile_rename(rs.getString("FILE_RENAME"));
				board.setContents(rs.getString("CONTENTS"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setModify_date(rs.getDate("MODIFY_DATE"));
				board.setReply(getReply(conn, board_no));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return board;
	}
	
	// INSERT - 게시글 작성
	public int insertBoard(Connection conn, BoardVO board) {
		PreparedStatement ps = null;
		int result = 0;
		
		String query = "INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, board.getWriter_id());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContents());
			ps.setString(4, board.getFile_origin());
			ps.setString(5, board.getFile_rename());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	
	// UPDATE - 게시글 수정
	public int updateBoard(Connection conn, BoardVO board) {
		PreparedStatement ps = null;
		int result = 0;
		String query = "UPDATE BOARD SET TITLE=?, CONTENTS=?, FILE_ORIGIN=?, FILE_RENAME=?, MODIFY_DATE=SYSDATE WHERE BOARD_NO=?";
		
		try {
			ps = conn.prepareStatement(query);
			
			if(board.getTitle() == null) {
				board.setTitle("");
			}
			ps.setString(1, board.getTitle());
			
			if(board.getContents() == null) {
				board.setTitle("");
			}
			ps.setString(2, board.getContents());
			
			ps.setString(3, board.getFile_origin());
			ps.setString(4, board.getFile_rename());
			ps.setString(5, board.getBoard_no());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	
	// DELETE - 게시글 삭제
	public int deleteBoard(Connection conn, String board_no) {
		PreparedStatement ps = null;
		int result = 0;
		String query = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, board_no);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	
	// UPDATE - 조회수 상승 쿼리
	public int updateReadCount(Connection conn, BoardVO board) {
		PreparedStatement ps = null;
		int result = 0;
		String query = "UPDATE BOARD SET READCOUNT=? WHERE BOARD_NO=?";
		
		try {
			ps = conn.prepareStatement(query);
			
			board.setReadcount(board.getReadcount() + 1);
			
			ps.setInt(1, board.getReadcount());
			ps.setString(2, board.getBoard_no());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	
	// SELECT - 댓글 조회
	public List<ReplyVO> getReply(Connection conn, String board_no) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<ReplyVO> list = new ArrayList<>();
		String query = "SELECT R.REPLY_NO, R.BOARD_NO, R.CONTENTS, M.ID, R.CREATE_DATE, R.MODIFY_DATE "
				+ "FROM REPLY R "
				+ "JOIN MEMBER M ON(R.WRITER = M.ID) "
				+ "WHERE BOARD_NO = ?"
				+ "ORDER BY REPLY_NO DESC ";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, board_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReplyVO reply = new ReplyVO();
				reply.setReply_no(rs.getString("REPLY_NO"));
				reply.setBoard_reply_no(rs.getString("BOARD_NO"));
				reply.setContents(rs.getString("CONTENTS"));
				reply.setWriter_id(rs.getString("ID"));
				reply.setCreate_date(rs.getDate("CREATE_DATE"));
				reply.setModify_date(rs.getDate("MODIFY_DATE"));
				
				list.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return list;
	}

	// INSERT - 댓글 입력
	public int insertReply(Connection conn, ReplyVO reply) {
		PreparedStatement ps = null;
		int result = 0;
		String query = "INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, reply.getBoard_reply_no());
			ps.setString(2, reply.getWriter_id());
			ps.setString(3, reply.getContents());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}
	
	// DELETE - 댓글 삭제
	public int deleteReply(Connection conn, String reply_no) {
		PreparedStatement ps = null;
		int result = 0;
		String query = "DELETE FROM REPLY WHERE REPLY_NO = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, reply_no);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

