package com.kh.semi.vo;

public class EvchargerDetail {
	private String statId;
	private String statNm;
	private String addr;
	private String useTime;
	private String lat;
	private String lng;

	public EvchargerDetail() {
	}

	public EvchargerDetail(String statId, String statNm, String addr, String useTime, String lat, String lng) {
		this.statId = statId;
		this.statNm = statNm;
		this.addr = addr;
		this.useTime = useTime;
		this.lat = lat;
		this.lng = lng;
	}

	public String getStatId() {
		return statId;
	}

	public void setStatId(String statId) {
		this.statId = statId;
	}

	public String getStatNm() {
		return statNm;
	}

	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
