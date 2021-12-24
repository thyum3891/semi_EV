package com.kh.semi.vo;

import java.util.Date;

public class Buy_Counseling {

	int bc_no;
	String u_name;
	String phone;
	String modelname;
	String application_date;
	String counseling_date;
	String time;
	String inflow_path;
	String additional_information;
	String check_counseling;
	public Buy_Counseling() {
	}
	public Buy_Counseling(int bc_no, String u_name, String phone, String modelname, String application_date,
			String counseling_date, String time, String inflow_path, String additional_information,
			String check_counseling) {
		this.bc_no = bc_no;
		this.u_name = u_name;
		this.phone = phone;
		this.modelname = modelname;
		this.application_date = application_date;
		this.counseling_date = counseling_date;
		this.time = time;
		this.inflow_path = inflow_path;
		this.additional_information = additional_information;
		this.check_counseling = check_counseling;
	}
	public int getBc_no() {
		return bc_no;
	}
	public void setBc_no(int bc_no) {
		this.bc_no = bc_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getCounseling_date() {
		return counseling_date;
	}
	public void setCounseling_date(String counseling_date) {
		this.counseling_date = counseling_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInflow_path() {
		return inflow_path;
	}
	public void setInflow_path(String inflow_path) {
		this.inflow_path = inflow_path;
	}
	public String getAdditional_information() {
		return additional_information;
	}
	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}
	public String getCheck_counseling() {
		return check_counseling;
	}
	public void setCheck_counseling(String check_counseling) {
		this.check_counseling = check_counseling;
	}

	
}