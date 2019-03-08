package br.com.les.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		String url = "jdbc:mariadb://localhost:3307/macshop";
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
