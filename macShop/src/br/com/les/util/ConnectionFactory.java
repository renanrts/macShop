package br.com.les.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(){
		
		String url = "jdbc:mariadb://localhost:3307/macshop";
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection(PreparedStatement stmt, Connection con) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
