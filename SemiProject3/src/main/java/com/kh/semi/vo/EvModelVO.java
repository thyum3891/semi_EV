package com.kh.semi.vo;

import java.util.Date;

public class EvModelVO {
	
	private int rowNum;
	private String modelName;
	private String modelSub;
	private int price;
	private String fuel;
	private String person;
	private String drive;
	private String transM;
	private String distance;
	private String energy;
	private String motor;
	private String company;
	private String nation;
	private String image_1;
	private String image_2;
	private String image_3;
	private String image_4;
	private String image_5;
	private int readcount;
	private Date createDate;
	
	public EvModelVO() {
	}
	
	public EvModelVO(String image_1){
		this.image_1 = image_1;		
	}
	
		
	public EvModelVO(String modelName, String modelSub, int price, String fuel, String person, String drive,
			String transM, String distance, String energy, String motor, String company, String nation, String image_1,
			String image_2, String image_3, String image_4, String image_5) {
		super();
		this.modelName = modelName;
		this.modelSub = modelSub;
		this.price = price;
		this.fuel = fuel;
		this.person = person;
		this.drive = drive;
		this.transM = transM;
		this.distance = distance;
		this.energy = energy;
		this.motor = motor;
		this.company = company;
		this.nation = nation;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.image_5 = image_5;
	}

	public EvModelVO(int rowNum, String modelName, String modelSub, int price, String fuel, String person,
			String drive, String transM, String distance, String energy, String motor, String company, String nation,
			String image_1, String image_2, String image_3, String image_4, String image_5, int readcount,
			Date createDate) {
		super();
		this.rowNum = rowNum;
		this.modelName = modelName;
		this.modelSub = modelSub;
		this.price = price;
		this.fuel = fuel;
		this.person = person;
		this.drive = drive;
		this.transM = transM;
		this.distance = distance;
		this.energy = energy;
		this.motor = motor;
		this.company = company;
		this.nation = nation;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.image_5 = image_5;
		this.readcount = readcount;
		this.createDate = createDate;
	}
	
	
	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelSub() {
		return modelSub;
	}

	public void setModelSub(String modelSub) {
		this.modelSub = modelSub;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getTransM() {
		return transM;
	}

	public void setTransM(String transM) {
		this.transM = transM;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getImage_1() {
		return image_1;
	}

	public void setImage_1(String image_1) {
		this.image_1 = image_1;
	}

	public String getImage_2() {
		return image_2;
	}

	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}

	public String getImage_3() {
		return image_3;
	}

	public void setImage_3(String image_3) {
		this.image_3 = image_3;
	}

	public String getImage_4() {
		return image_4;
	}

	public void setImage_4(String image_4) {
		this.image_4 = image_4;
	}

	public String getImage_5() {
		return image_5;
	}

	public void setImage_5(String image_5) {
		this.image_5 = image_5;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "EvModelVO [rowNum=" + rowNum + ", modelName=" + modelName + ", modelSub=" + modelSub + ", price="
				+ price + ", fuel=" + fuel + ", person=" + person + ", drive=" + drive + ", transM=" + transM
				+ ", distance=" + distance + ", energy=" + energy + ", motor=" + motor + ", company=" + company
				+ ", nation=" + nation + ", image_1=" + image_1 + ", image_2=" + image_2 + ", image_3=" + image_3
				+ ", image_4=" + image_4 + ", image_5=" + image_5 + ", readcount=" + readcount + ", createDate="
				+ createDate + "]";
	}
	
	
	
}
