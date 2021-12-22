package com.kh.semi.DAO;

import static common.JDBCTemplate.close;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.util.PageInfo;
import com.kh.model.service.EvModelService;
import com.kh.semi.vo.EvModelVO;

public class EvModelDAO {
	
	
	//전기차 상세정보.csv 파싱
	public void fileRead(String path) {
		
		try (
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)
				){
			String str = null;
			
			while((str = br.readLine()) != null) {
				String[] array = str.split(",");
				List<String> list = new ArrayList<String>();
				
				for(int i = 0; i<array.length; i++) {
					list.add(array[i]);
				}
				
				int i = 0;
				
				String modelName = list.get(i);
				String modelSub = list.get(i+1); 
				String price = list.get(i+2);
				String fuel = list.get(i+3);     
				String person = list.get(i+4);   
				String drive = list.get(i+5);    
				String transM = list.get(i+6);   
				String distance = list.get(i+7); 
				String energy = list.get(i+8);   
				String motor = list.get(i+9);    
				String company = list.get(i+10);  
				String nation = list.get(i+11);   
				String image_1 = list.get(i+12);  
				String image_2 = list.get(i+13);  
				String image_3 = list.get(i+14);  
				String image_4 = list.get(i+15);  
				String image_5 = list.get(i+16);
				
				EvModelVO evModel = new EvModelVO(modelName, modelSub, Integer.parseInt(price), fuel, person, drive,
						transM, distance, energy, motor, company, nation,
						image_1, image_2, image_3, image_4, image_5);
				
				System.out.println(evModel.toString());
				
				EvModelService service = new EvModelService();
				service.save(evModel);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//전기차 데이터 삽입
	public int insertEvModel(Connection conn,EvModelVO evModel) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO EV VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, evModel.getModelName());
			pstmt.setString(2, evModel.getModelSub());
			pstmt.setInt(3, evModel.getPrice());
			pstmt.setString(4, evModel.getFuel());
			pstmt.setString(5, evModel.getPerson());
			pstmt.setString(6, evModel.getDrive());
			pstmt.setString(7, evModel.getTransM());
			pstmt.setString(8, evModel.getDistance());
			pstmt.setString(9, evModel.getEnergy());
			pstmt.setString(10, evModel.getMotor());
			pstmt.setString(11, evModel.getCompany());
			pstmt.setString(12, evModel.getNation());
			pstmt.setString(13, evModel.getImage_1());
			pstmt.setString(14, evModel.getImage_2());
			pstmt.setString(15, evModel.getImage_3());
			pstmt.setString(16, evModel.getImage_4());
			pstmt.setString(17, evModel.getImage_5());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//전기차 데이터 count
	public int selectEv(Connection conn){
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM EV";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next() == true) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	//페이지 당 불러올 전기차 데이터(조회순=default)
	public List<EvModelVO> selectEv(Connection conn,PageInfo pageInfo){
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query =  "select * from (SELECT ROWNUM RNUM,modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate from"
				+ "(SELECT modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate FROM EV ORDER BY readcount DESC))"
				+ "WHERE RNUM BETWEEN ? AND ?";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setRowNum(rs.getInt("RNUM"));
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getInt("price"));
				evm.setFuel(rs.getString("fuel"));
				evm.setPerson(rs.getString("person"));
				evm.setDrive(rs.getString("drive"));
				evm.setTransM(rs.getString("transM"));
				evm.setDistance(rs.getString("distance"));
				evm.setEnergy(rs.getString("energy"));
				evm.setMotor(rs.getString("motor"));
				evm.setCompany(rs.getString("company"));
				evm.setNation(rs.getString("nation"));
				evm.setImage_1(rs.getString("image_1"));
				evm.setImage_2(rs.getString("image_2"));
				evm.setImage_3(rs.getString("image_3"));
				evm.setImage_4(rs.getString("image_4"));
				evm.setImage_5(rs.getString("image_5"));
				evm.setReadcount(rs.getInt("readcount"));
				evm.setCreateDate(rs.getDate("createDate"));				
				
				list.add(evm);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	//원래 조회수 가져오기
	public EvModelVO findEvModelNo(Connection conn, String modelName, String modelSub) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT modelName,modelSub,readcount FROM ev WHERE modelName=? AND modelSub=?";
		
		EvModelVO evm = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, modelName);
			pstmt.setString(2, modelSub);
			rs = pstmt.executeQuery();
			
			if(rs.next() == true) {
				evm = new EvModelVO();
				
//				evm.setRowNum(rs.getInt("RNUM"));
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
//				evm.setPrice(rs.getInt("price"));
//				evm.setFuel(rs.getString("fuel"));
//				evm.setPerson(rs.getString("person"));
//				evm.setDrive(rs.getString("drive"));
//				evm.setTransM(rs.getString("transM"));
//				evm.setDistance(rs.getString("distance"));
//				evm.setEnergy(rs.getString("energy"));
//				evm.setMotor(rs.getString("motor"));
//				evm.setCompany(rs.getString("company"));
//				evm.setNation(rs.getString("nation"));
//				evm.setImage_1(rs.getString("image_1"));
//				evm.setImage_2(rs.getString("image_2"));
//				evm.setImage_3(rs.getString("image_3"));
//				evm.setImage_4(rs.getString("image_4"));
//				evm.setImage_5(rs.getString("image_5"));
				evm.setReadcount(rs.getInt("readcount"));
//				evm.setCreateDate(rs.getDate("createDate"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return evm;
	}
	
	//조회수 1 증가
	public int updateReadCount(Connection conn, EvModelVO evmodel) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			query = "UPDATE ev SET readcount=? WHERE modelName=? AND modelSub=?";
			pstmt = conn.prepareStatement(query);
			
			evmodel.setReadcount(evmodel.getReadcount() + 1);
			
			pstmt.setInt(1, evmodel.getReadcount());
			pstmt.setString(2, evmodel.getModelName());
			pstmt.setString(3, evmodel.getModelSub());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//높은가격순
	public List<EvModelVO> selectEvhPrice(Connection conn,PageInfo pageInfo){
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query =  "select * from (SELECT ROWNUM RNUM,modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate from"
				+ "(SELECT modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate FROM EV ORDER BY price DESC))"
				+ "WHERE RNUM BETWEEN ? AND ?";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setRowNum(rs.getInt("RNUM"));
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getInt("price"));
				evm.setFuel(rs.getString("fuel"));
				evm.setPerson(rs.getString("person"));
				evm.setDrive(rs.getString("drive"));
				evm.setTransM(rs.getString("transM"));
				evm.setDistance(rs.getString("distance"));
				evm.setEnergy(rs.getString("energy"));
				evm.setMotor(rs.getString("motor"));
				evm.setCompany(rs.getString("company"));
				evm.setNation(rs.getString("nation"));
				evm.setImage_1(rs.getString("image_1"));
				evm.setImage_2(rs.getString("image_2"));
				evm.setImage_3(rs.getString("image_3"));
				evm.setImage_4(rs.getString("image_4"));
				evm.setImage_5(rs.getString("image_5"));
				evm.setReadcount(rs.getInt("readcount"));
				evm.setCreateDate(rs.getDate("createDate"));				
				
				list.add(evm);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	//낮은가격순
	public List<EvModelVO> selectEvrPrice(Connection conn,PageInfo pageInfo){
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query =  "select * from (SELECT ROWNUM RNUM,modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate from"
				+ "(SELECT modelName,modelSub,price,fuel,person,drive,"
				+ "transM,distance,energy,motor,company,nation,"
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate FROM EV ORDER BY price ASC))"
				+ "WHERE RNUM BETWEEN ? AND ?";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setRowNum(rs.getInt("RNUM"));
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getInt("price"));
				evm.setFuel(rs.getString("fuel"));
				evm.setPerson(rs.getString("person"));
				evm.setDrive(rs.getString("drive"));
				evm.setTransM(rs.getString("transM"));
				evm.setDistance(rs.getString("distance"));
				evm.setEnergy(rs.getString("energy"));
				evm.setMotor(rs.getString("motor"));
				evm.setCompany(rs.getString("company"));
				evm.setNation(rs.getString("nation"));
				evm.setImage_1(rs.getString("image_1"));
				evm.setImage_2(rs.getString("image_2"));
				evm.setImage_3(rs.getString("image_3"));
				evm.setImage_4(rs.getString("image_4"));
				evm.setImage_5(rs.getString("image_5"));
				evm.setReadcount(rs.getInt("readcount"));
				evm.setCreateDate(rs.getDate("createDate"));				
				
				list.add(evm);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	//검색한 데이터만
	public List<EvModelVO> selectEvSearch(Connection conn, PageInfo pageInfo, String keyword) {
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT RNUM,modelName,modelSub,price,fuel,person,drive, "
				+ "transM,distance,energy,motor,company,nation, "
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate from "
				+ "(SELECT ROWNUM AS RNUM,modelName,modelSub,price,fuel,person,drive, "
				+ "transM,distance,energy,motor,company,nation, "
				+ "image_1,image_2,image_3,image_4,image_5, readcount,createDate FROM EV "
				+ "WHERE modelname LIKE ? OR company LIKE ?) "
				+ "WHERE RNUM BETWEEN ? AND ? ";

		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setInt(3, pageInfo.getStartList());
			pstmt.setInt(4, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setRowNum(rs.getInt("RNUM"));
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getInt("price"));
				evm.setFuel(rs.getString("fuel"));
				evm.setPerson(rs.getString("person"));
				evm.setDrive(rs.getString("drive"));
				evm.setTransM(rs.getString("transM"));
				evm.setDistance(rs.getString("distance"));
				evm.setEnergy(rs.getString("energy"));
				evm.setMotor(rs.getString("motor"));
				evm.setCompany(rs.getString("company"));
				evm.setNation(rs.getString("nation"));
				evm.setImage_1(rs.getString("image_1"));
				evm.setImage_2(rs.getString("image_2"));
				evm.setImage_3(rs.getString("image_3"));
				evm.setImage_4(rs.getString("image_4"));
				evm.setImage_5(rs.getString("image_5"));
				evm.setReadcount(rs.getInt("readcount"));
				evm.setCreateDate(rs.getDate("createDate"));				
				
				list.add(evm);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;

	}

}




