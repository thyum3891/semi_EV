package com.kh.semi.vo;

import java.util.Date;
import java.util.List;

public class BoardVO {

	private String board_no;
	private int rowNum;
	private String writer;
	private String writer_id;
    private String title;
    private String contents;
    private String file_origin;
    private String file_rename;
    private int readcount;
    private List<ReplyVO> reply;
    private Date create_date;
    private Date modify_date;
    
	public BoardVO() {
	}

	public BoardVO(String board_no, int rowNum, String writer, String writer_id, String title, String contents,
			String file_origin, String file_rename, int readcount, List<ReplyVO> reply, Date create_date,
			Date modify_date) {
		super();
		this.board_no = board_no;
		this.rowNum = rowNum;
		this.writer = writer;
		this.writer_id = writer_id;
		this.title = title;
		this.contents = contents;
		this.file_origin = file_origin;
		this.file_rename = file_rename;
		this.readcount = readcount;
		this.reply = reply;
		this.create_date = create_date;
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", rowNum=" + rowNum + ", writer=" + writer + ", writer_id="
				+ writer_id + ", title=" + title + ", contents=" + contents + ", file_origin=" + file_origin
				+ ", file_rename=" + file_rename + ", readcount=" + readcount + ", reply=" + reply + ", create_date="
				+ create_date + ", modify_date=" + modify_date + "]";
	}

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFile_origin() {
		return file_origin;
	}

	public void setFile_origin(String file_origin) {
		this.file_origin = file_origin;
	}

	public String getFile_rename() {
		return file_rename;
	}

	public void setFile_rename(String file_rename) {
		this.file_rename = file_rename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public List<ReplyVO> getReply() {
		return reply;
	}

	public void setReply(List<ReplyVO> reply) {
		this.reply = reply;
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
