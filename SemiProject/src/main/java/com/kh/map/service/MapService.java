package com.kh.map.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.JDBCTemplate.*;

import com.kh.semi.DAO.EvChargerDAO;
import com.kh.semi.vo.EvCharger;

import common.Distance;

public class MapService {
	private static EvChargerDAO dao = new EvChargerDAO();
	private static Map<String, Map<String, String>> staticMap = dao.selectAllMap(getConnection());

	public void passingAPI() {
		Connection connection = getConnection();

		dao.passing(connection);

	}

	public int insertEvcharger(EvCharger evCharger) {

		Connection connection = getConnection();

		int result = dao.insertEvCharger(connection, evCharger);

		return result;
	}

	public Map<String, Map<String, String>> selectAllMap() {
		return dao.selectAllMap(getConnection());

	}
//	public List<Map<String,String>> selectDetailAll(){
//		Connection connection = getConnection();
//		List<String> keyList = dao.selectDetailAll(connection);
//		List<Map<String,String>> list = 
//		
//		
//
//			@Override
//			public int compare(Map<String, String> o1, Map<String, String> o2) {
//				int result = Integer.compare(Integer.parseInt(o1.get("distance")), Integer.parseInt(o2.get("distance")));
//				return result;
//			}
//		});
//		
//		return null ;
//	}

	public List<Map<String, String>> selectDetailAll(String lat, String lng) {
		Connection connection = getConnection();
		List<String> list = dao.selectDetailAll(connection);

		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

		for (String s : list) {
			mapList.add(selectDetailMap(lat, lng, s));
		}

		mapList.sort(new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				int result = Integer.compare(Integer.parseInt(o1.get("distance")),
						Integer.parseInt(o2.get("distance")));
				return result;
			}
		});

		return mapList;
	}

	public List<Map<String, String>> selectDetailQuery(String lat, String lng, String query) {
		Connection connection = getConnection();
		List<String> list = dao.selectDetailQuery(connection,query);
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		
		for (String s : list) {
			mapList.add(selectDetailMap(lat, lng, s));
		}
		
		mapList.sort(new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				int result = Integer.compare(Integer.parseInt(o1.get("distance")),
						Integer.parseInt(o2.get("distance")));
				return result;
			}
		});

		return mapList;
	}

	public Map<String, String> selectDetailMap(String geoLat, String geoLng, String statId) {

		Map<String, String> map = new HashMap<String, String>();

		String lat = staticMap.get(statId).get("lat");
		String lng = staticMap.get(statId).get("lng");

		map.put("statId", staticMap.get(statId).get("statId"));
		map.put("statNm", staticMap.get(statId).get("statNm"));
		map.put("addr", staticMap.get(statId).get("addr"));
		map.put("useTime", staticMap.get(statId).get("useTime"));
		map.put("lat", lat);
		map.put("lng", lng);
		double lat1 = Double.parseDouble(geoLat);
		double lng1 = Double.parseDouble(geoLng);
		double lat2 = Double.parseDouble(lat);
		double lng2 = Double.parseDouble(lng);
		Double distance = (Distance.distance(lat1, lng1, lat2, lng2, "meter"));
		map.put("distance", "" + Math.round(distance));

		int stat_1 = 0;
		int stat_2 = 0;
		int stat_3 = 0;
		int stat_4 = 0;
		int stat_5 = 0;
		int stat_9 = 0;
		if (staticMap.containsKey(statId + "(stat_1)")) {
			map.put("stat_1", staticMap.get(statId + "(stat_1)").get("count"));
			 stat_1 = Integer.parseInt(map.get("stat_1"));
		}else {
			map.put("stat_1","0");
		}
		if (staticMap.containsKey(statId + "(stat_2)")) {
			map.put("stat_2", staticMap.get(statId + "(stat_2)").get("count"));
			 stat_2 = Integer.parseInt(map.get("stat_2"));
		}else {
			map.put("stat_2","0");
		}
		if (staticMap.containsKey(statId + "(stat_3)")) {
			map.put("stat_3", staticMap.get(statId + "(stat_3)").get("count"));
			 stat_4 = Integer.parseInt(map.get("stat_3"));
		}else {
			map.put("stat_3","0");
		}
		if (staticMap.containsKey(statId + "(stat_4)")) {
			map.put("stat_4", staticMap.get(statId + "(stat_4)").get("count"));
		}else {
			map.put("stat_4","0");
		}
		if (staticMap.containsKey(statId + "(stat_5)")) {
			map.put("stat_5", staticMap.get(statId + "(stat_5)").get("count"));
			 stat_5 = Integer.parseInt(map.get("stat_5"));
		}else {
			map.put("stat_5","0");
		}
		if (staticMap.containsKey(statId + "(stat_9)")) {
			map.put("stat_9", staticMap.get(statId + "(stat_9)").get("count"));
			 stat_9 = Integer.parseInt(map.get("stat_9"));
		}else {
			map.put("stat_9","0");
		}
		
		map.put("count", "" + (stat_1 + stat_2 + stat_3 + stat_4 + stat_5 + stat_9));
		if (staticMap.containsKey(statId + "(stat_1)") == true) {

		}

		return map;

	}

	public static void main(String[] args) {
		String lat = "37.4536062";
		String lng = "127.0428005";
		System.out.println(staticMap.size());
		List<Map<String, String>> list = new MapService().selectDetailQuery(lat, lng, "");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println(list.size());

	}
}
