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
				
				EvModelVO evModel = new EvModelVO(modelName, modelSub, price, fuel, person, drive,
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
			pstmt.setString(3, evModel.getPrice());
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
	
	//전기차 데이터 불러오기
	public List<EvModelVO> selectEv(Connection conn){
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM EV";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getString("price"));
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
	
	//페이지 당 불러올 전기차 데이터
	public List<EvModelVO> selectEv(Connection conn,PageInfo pageInfo){
		
		List<EvModelVO> list = new ArrayList<EvModelVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM EV";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EvModelVO evm = new EvModelVO();
				
				evm.setModelName(rs.getString("modelName"));
				evm.setModelSub(rs.getString("modelSub"));
				evm.setPrice(rs.getString("price"));
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







