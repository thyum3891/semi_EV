package com.kh.semi.vo;

import java.util.Date;

public class ReplyVO {

	private String reply_no;
	private String board_reply_no;
	private String writer_no;
	private String writer_id;
	private String contents;
	private Date create_date;
	private Date modify_date;
	
	public ReplyVO() {
	}

	public ReplyVO(String reply_no, String board_reply_no, String writer_no, String writer_id, String contents,
			Date create_date, Date modify_date) {
		super();
		this.reply_no = reply_no;
		this.board_reply_no = board_reply_no;
		this.writer_no = writer_no;
		this.writer_id = writer_id;
		this.contents = contents;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", board_reply_no=" + board_reply_no + ", writer_no=" + writer_no
				+ ", writer_id=" + writer_id + ", contents=" + contents + ", create_date=" + create_date
				+ ", modify_date=" + modify_date + "]";
	}

	public String getReply_no() {
		return reply_no;
	}

	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}

	public String getBoard_reply_no() {
		return board_reply_no;
	}

	public void setBoard_reply_no(String board_reply_no) {
		this.board_reply_no = board_reply_no;
	}

	public String getWriter_no() {
		return writer_no;
	}

	public void setWriter_no(String writer_no) {
		this.writer_no = writer_no;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	
}
