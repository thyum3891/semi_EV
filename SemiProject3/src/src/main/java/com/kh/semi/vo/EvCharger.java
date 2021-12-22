package com.kh.semi.vo;

public class EvCharger {

	String statNm;
	String statId;
	String chgerId;
	String chgerType;
	String addr;
	String lat;
	String lng;
	String useTime;
	String bnm;
	String busiNm;
	String busiCall;
	String stat;
	String statUpdDt;
	String parkingFree;
	String note;
	String limitYn;
	String delYn;

	public EvCharger() {
	}

	public EvCharger(String statNm, String statId, String chgerId, String chgerType, String addr, String lat,
			String lng, String useTime, String bnm, String busiNm, String busiCall, String stat, String statUpdDt,
			String parkingFree, String note, String limitYn, String delYn) {
		this.statNm = statNm;
		this.statId = statId;
		this.chgerId = chgerId;
		this.chgerType = chgerType;
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
		this.useTime = useTime;
		this.bnm = bnm;
		this.busiNm = busiNm;
		this.busiCall = busiCall;
		this.stat = stat;
		this.statUpdDt = statUpdDt;
		this.parkingFree = parkingFree;
		this.note = note;
		this.limitYn = limitYn;
		this.delYn = delYn;
	}

	public String getStatNm() {
		return statNm;
	}

	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}

	public String getStatId() {
		return statId;
	}

	public void setStatId(String statId) {
		this.statId = statId;
	}

	public String getChgerId() {
		return chgerId;
	}

	public void setChgerId(String chgerId) {
		this.chgerId = chgerId;
	}

	public String getChgerType() {
		return chgerType;
	}

	public void setChgerType(String chgerType) {
		this.chgerType = chgerType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getBnm() {
		return bnm;
	}

	public void setBnm(String bnm) {
		this.bnm = bnm;
	}

	public String getBusiNm() {
		return busiNm;
	}

	public void setBusiNm(String busiNm) {
		this.busiNm = busiNm;
	}

	public String getBusiCall() {
		return busiCall;
	}

	public void setBusiCall(String busiCall) {
		this.busiCall = busiCall;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getStatUpdDt() {
		return statUpdDt;
	}

	public void setStatUpdDt(String statUpdDt) {
		this.statUpdDt = statUpdDt;
	}

	public String getParkingFree() {
		return parkingFree;
	}

	public void setParkingFree(String parkingFree) {
		this.parkingFree = parkingFree;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLimitYn() {
		return limitYn;
	}

	public void setLimitYn(String limitYn) {
		this.limitYn = limitYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "EvChargerVO ['" + statNm + "','" + statId + "','" + chgerId + "','"
				+ chgerType + "','" + addr + "','" + lat + "','" + lng + "','" + useTime + "','"
				+ bnm + "','" + busiNm + "','" + busiCall + "','" + stat + "','" + statUpdDt
				+ "','" + parkingFree + "','" + note + "','" + limitYn + "','" + delYn + "']";
	}

}
