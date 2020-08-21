package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public static String url = "jdbc:postgresql://localhost:5432/testbcaf";
	public static String user = "postgres";
	public static String pass = "";
	Connection connect = null;
	
	public Connection getConnection() {
		
		try {
			connect = DriverManager.getConnection(url,user,pass);
			if (connect != null ) {
				
				return connect;
			}else {
				System.out.println("Koneksi gagal");
			}
		}catch(SQLException e) {
			System.out.println("sistem gagal "+e);
		}
		return connect;
	}
	
	public void closeConnection() {
		try {
			connect.close();	
		}catch(SQLException e) {
			System.out.println(""+e);
		}
		
	}
}
