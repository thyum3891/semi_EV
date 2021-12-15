package com.kh.semi.vo;

public class Location {
	String statId;
	String lat;
	String lng;
	public Location(String statId, String lat, String lng) {
		this.statId = statId;
		this.lat = lat;
		this.lng = lng;
	}
	public Location() {
	}
	public String getStatId() {
		return statId;
	}
	public void setStatId(String statId) {
		this.statId = statId;
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
