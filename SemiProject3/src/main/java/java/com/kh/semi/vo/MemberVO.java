package com.kh.semi.vo;

import java.sql.Date;

public class MemberVO {

	private int user_no;
    private String id;
    private String pwd;
    private String role;
    private String name;
    private String phone;
    private Date enroll_date;
    
	public MemberVO() {
	}
	public MemberVO(int user_no, String id, String pwd, String role, String name, String phone, Date enroll_date) {
		super();
		this.user_no = user_no;
		this.id = id;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.enroll_date = enroll_date;
	}
	@Override
	public String toString() {
		return "MemberVO [user_no=" + user_no + ", id=" + id + ", pwd=" + pwd + ", role=" + role + ", name=" + name
				+ ", phone=" + phone + ", enroll_date=" + enroll_date + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
}
