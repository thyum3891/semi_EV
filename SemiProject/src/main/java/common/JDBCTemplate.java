package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection connection = null;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			String url = "jdbc:oracle:thin:@localhost:1522:xe";
			String name = "semi";
			String pw = "semi";
			connection = DriverManager.getConnection(url, name, pw);
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public static void commit(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.rollback();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statusment) {
		try {
			if(statusment != null && !statusment.isClosed()) {
				statusment.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resultSet) {
		try {
			if(resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
//	public static void main(String[] args) {
//		JDBCTemplate.getConnection();
//		System.out.println("!!");
//	}
	
//	<button type="button" onclick="mapAJAX()">검색</button>
