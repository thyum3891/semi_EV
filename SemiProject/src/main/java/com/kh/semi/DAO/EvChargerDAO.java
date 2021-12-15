package com.kh.semi.DAO;

import static common.JDBCTemplate.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.semi.api.EvChargerAPI;
import com.kh.semi.vo.EvCharger;

import common.Distance;

public class EvChargerDAO {

	public void passing(Connection conn) {
		deleteAllEvChargerAPI(conn);
		Map<String, List<String>> map = new HashMap<>();
		List<String> xmlList = null;
		try {
			for (int i = 0; i < 13; i++) {
				xmlList = new ArrayList<String>(Arrays.asList(EvChargerAPI.xml(i + 1).split("<item>")));
				map.put(i + "", xmlList);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < map.size(); i++) {
			List<String> list = map.get(i + "");

			for (int j = 1; j < list.size(); j++) {
				String str = list.get(j);

				String statNm = str.substring("<statNm>".length() + str.indexOf("<statNm>"),
						str.lastIndexOf("</statNm>"));
				if (statNm.equals("null") || statNm == null) {
					continue;
				}
				String statId = str.substring("<statId>".length() + str.indexOf("<statId>"),
						str.lastIndexOf("</statId>"));
				String chgerId = str.substring("<chgerId>".length() + str.indexOf("<chgerId>"),
						str.lastIndexOf("</chgerId>"));
				String chgerType = str.substring("<chgerType>".length() + str.indexOf("<chgerType>"),
						str.lastIndexOf("</chgerType>"));
				String addr = str.substring("<addr>".length() + str.indexOf("<addr>"), str.lastIndexOf("</addr>"));

				if (addr.equals("null") || addr == null) {
					continue;
				}

				String lat = str.substring("<lat>".length() + str.indexOf("<lat>"), str.lastIndexOf("</lat>"));
				String lng = str.substring("<lng>".length() + str.indexOf("<lng>"), str.lastIndexOf("</lng>"));
				String useTime = str.substring("<useTime>".length() + str.indexOf("<useTime>"),
						str.lastIndexOf("</useTime>"));
				if (useTime.equals("")) {
					useTime = "정보 없음";
				}
				String bnm = str.substring("<bnm>".length() + str.indexOf("<bnm>"), str.lastIndexOf("</bnm>"));
				String busiNm = str.substring("<busiNm>".length() + str.indexOf("<busiNm>"),
						str.lastIndexOf("</busiNm>"));
				String busiCall = str.substring("<busiCall>".length() + str.indexOf("<busiCall>"),
						str.lastIndexOf("</busiCall>"));
				String stat = str.substring("<stat>".length() + str.indexOf("<stat>"), str.lastIndexOf("</stat>"));
				String statUpdDt = str.substring("<statUpdDt>".length() + str.indexOf("<statUpdDt>"),
						str.lastIndexOf("</statUpdDt>"));
				String parkingFree = str.substring("<parkingFree>".length() + str.indexOf("<parkingFree>"),
						str.lastIndexOf("</parkingFree>"));
				String note = str.substring("<note>".length() + str.indexOf("<note>"), str.lastIndexOf("</note>"));
				if (note.equals("")) {
					note = "특이사항 없음";
				}
				String limitYn = str.substring("<limitYn>".length() + str.indexOf("<limitYn>"),
						str.lastIndexOf("</limitYn>"));
				String delYn = str.substring("<delYn>".length() + str.indexOf("<delYn>"), str.lastIndexOf("</delYn>"));

				EvCharger evCharger = new EvCharger(statNm, statId, chgerId, chgerType, addr, lat, lng, useTime, bnm,
						busiNm, busiCall, stat, statUpdDt, parkingFree, note, limitYn, delYn);

				insertEvCharger(conn, evCharger);

			}
		}

	}// 파싱 및 인서트

	public int insertEvCharger(Connection conn, EvCharger evChargerVO) {

		PreparedStatement pstm = null;

		try {
//			String sql = "INSERT INTO  EVCHARGER_API VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String sql = "INSERT INTO  EVCHARGER_API VALUES(?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?),?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, evChargerVO.getStatNm());
			pstm.setString(2, evChargerVO.getStatId());
			pstm.setString(3, evChargerVO.getChgerId());
			pstm.setString(4, evChargerVO.getChgerType());
			pstm.setString(5, evChargerVO.getAddr());
			pstm.setString(6, evChargerVO.getLat());
			pstm.setString(7, evChargerVO.getLng());
			pstm.setString(8, evChargerVO.getUseTime());
			pstm.setString(9, evChargerVO.getBnm());
			pstm.setString(10, evChargerVO.getBusiNm());
			pstm.setString(11, evChargerVO.getBusiCall());
			pstm.setString(12, evChargerVO.getStat());
			pstm.setString(13, evChargerVO.getStatUpdDt().substring(0, 8));
			pstm.setString(14, evChargerVO.getParkingFree());
			pstm.setString(15, evChargerVO.getNote());
			pstm.setString(16, evChargerVO.getLimitYn());
			pstm.setString(17, evChargerVO.getDelYn());

			int result = pstm.executeUpdate();

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}

			return result;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

				if (pstm != null) {
					pstm.close();
				}

			} catch (SQLException e) {
				//
				e.printStackTrace();
			}

		}
		return -1;
	}

	public int deleteAllEvChargerAPI(Connection conn) {

		PreparedStatement pstm = null;

		try {
			String sql = "DELETE FROM EVCHARGER_API";
			pstm = conn.prepareStatement(sql);

			int result = pstm.executeUpdate();

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}

			return result;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

				if (pstm != null) {
					pstm.close();
				}

			} catch (SQLException e) {
				//
				e.printStackTrace();
			}

		}
		return -1;
	}

//	public Map<String, List<Map<String,String>>> selectAllMapDetail(Connection conn) {
//
//		Map<String, List<Map<String,String>>> selectAllMap = new HashMap<>();
//		String sql = "SELECT * FROM evcharger_api";  
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next() == true) {
//				String statId = rs.getString("STATID");
//				List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//				if(selectAllMap.containsKey(statId)==true) {
//					list = selectAllMap.get(statId);
//				}
//				Map<String,String> map = new HashMap<String, String>();
//
//						map.put("statId", statId);
//						map.put("statNm", rs.getString("STATNM"));
//						map.put("addr", rs.getString("ADDR"));
//						map.put("useTime", rs.getString("USETIME"));
//						map.put("lat", rs.getString("LAT"));
//						map.put("lng", rs.getString("LNG"));
//						map.put("chgertype",rs.getString("CHGERTYPE"));
//						map.put("chgerId",rs.getString("CHGERID"));
//						map.put("stat", rs.getString("STAT"));
//						
//						list.add(map);
//
//				}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//			close(rs);
//			close(conn);
//		}
//
//		return selectAllMap;
//	}
	
	public Map<String, Map<String,String>> selectAllMap(Connection conn) {

		Map<String, Map<String,String>> selectAllMap = new HashMap<>();
		String sql = "SELECT  STATID, STATNM, ADDR, LAT, LNG, USETIME, stat, count(stat) count FROM evcharger_api  GROUP BY stat, STATID, STATNM, ADDR, USETIME, LAT, LNG";  

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				Map<String,String> map = new HashMap<String, String>();
				String statId = rs.getString("STATID");
						map.put("statId", statId);
						map.put("statNm", rs.getString("STATNM"));
						map.put("addr", rs.getString("ADDR"));
						map.put("useTime", rs.getString("USETIME"));
						map.put("lat", rs.getString("LAT"));
						map.put("lng", rs.getString("LNG"));
						selectAllMap.put(statId, map);
						String count = rs.getString("count");
						if(count==null) {
							count = "0";
						}
						map.put("count", count);
					char stat = rs.getString("stat").charAt(0);

					switch (stat) {
					case '1':
						selectAllMap.put(statId+"(stat_1)", map);
						break;
					case '2':
						selectAllMap.put(statId+"(stat_2)", map);
						break;
					case '3':
						selectAllMap.put(statId+"(stat_3)", map);
						break;
					case '4':
						selectAllMap.put(statId+"(stat_4)", map);
						break;
					case '5':
						selectAllMap.put(statId+"(stat_5)", map);
						break;
					case '9':
						selectAllMap.put(statId+"(stat_9)", map);
						break;

					default:
						break;
					}

				}
				
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
			close(conn);
		}

		return selectAllMap;
	}

	public Map<String, String> selectDetail(Connection conn, String statId, String geoLat, String geoLng) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("stat_1", "0");
		map.put("stat_2", "0");
		map.put("stat_3", "0");
		map.put("stat_4", "0");
		map.put("stat_5", "0");
		map.put("stat_9", "0");

		/*
		 * (1: 통신이상, 2: 충전대기, 3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)
		 */

		String sql = "SELECT  STATID, STATNM, ADDR, LAT, LNG, USETIME, stat, count(stat) count FROM evcharger_api  WHERE STATID = ? GROUP BY stat, STATID, STATNM, ADDR, USETIME, LAT, LNG";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, statId);
			rs = pstmt.executeQuery();

			for (int i = 0; rs.next(); i++) {
				if (i == 0) {

					String lat = rs.getString("LAT");
					String lng = rs.getString("LNG");

					map.put("statId", rs.getString("STATID"));
					map.put("statNm", rs.getString("STATNM"));
					map.put("addr", rs.getString("ADDR"));
					map.put("useTime", rs.getString("USETIME"));
					map.put("lat", lat);
					map.put("lng", lng);
					double lat1 = Double.parseDouble(geoLat);
					double lng1 = Double.parseDouble(geoLng);
					double lat2 = Double.parseDouble(lat);
					double lng2 = Double.parseDouble(lng);
					Double distance = (Distance.distance(lat1, lng1, lat2, lng2, "meter"));
					map.put("distance", "" + Math.round(distance));

				}
				String count = "0";
				char stat = rs.getString("stat").charAt(0);

				switch (stat) {
				case '1':
					count = rs.getString("count");
					map.put("stat_1", count);
					break;
				case '2':
					count = rs.getString("count");
					map.put("stat_2", count);
					break;
				case '3':
					count = rs.getString("count");
					map.put("stat_3", count);
					break;
				case '4':
					count = rs.getString("count");
					map.put("stat_4", count);
					break;
				case '5':
					count = rs.getString("count");
					map.put("stat_5", count);
					break;
				case '9':
					count = rs.getString("count");
					map.put("stat_9", count);
					break;

				default:
					break;
				}

			}
			int stat_1 = Integer.parseInt(map.get("stat_1"));
			int stat_2 = Integer.parseInt(map.get("stat_2"));
			int stat_3 = Integer.parseInt(map.get("stat_3"));
			int stat_4 = Integer.parseInt(map.get("stat_4"));
			int stat_5 = Integer.parseInt(map.get("stat_5"));
			int stat_9 = Integer.parseInt(map.get("stat_9"));

			map.put("count", "" + (stat_1 + stat_2 + stat_3 + stat_4 + stat_5 + stat_9));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return map;
	}

	public List<String> selectDetailQuery(Connection conn, String query) {
		List<String> list = new ArrayList<>();

		String sql = "SELECT STATID FROM evcharger_api WHERE ADDR LIKE ?  GROUP BY STATID, ADDR";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("STATID"));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
			close(conn);
		}

		return list;
	}

	public List<String> selectDetailAll(Connection conn) {
		List<String> keyList = new ArrayList<String>();

		String sql = "SELECT STATID FROM evcharger_api GROUP BY STATID";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				keyList.add(rs.getString("STATID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
			close(conn);
		}

		return keyList;
	}
	

}
