package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaldoDAO {

	String TABLE = "saldo";
	String COL_ID = "id";
	String COL_NAMA = "nama";
	String COL_SALDO =  "saldo";
	String COL_KREDIT =  "total_kredit";
	DataSource data = new DataSource();
	
	public void createTableSaldo() {
		String sql ="CREATE TABLE IF NOT EXISTS "+TABLE+" ("
				+COL_ID+ " VARCHAR(5) NOT NULL,"
				+COL_NAMA+ " VARCHAR(15) NOT NULL,"
				+COL_SALDO+ " INT NOT NULL,"
				+COL_KREDIT+ " INT NOT NULL,"
				+ "CONSTRAINT pk_saldo primary key ("+COL_ID+"))";
		

		
		Connection konek = data.getConnection();
		try {
			Statement state = konek.createStatement();
			state.execute(sql);
			System.out.println("Tabel Daftar Tarif Tercipta");
			state.close(); 
			konek.close();
		}catch(SQLException e) {
			System.out.println("terjadi Kesalahan"+e);
		}
	}
	
	public void insertNasabah(String id, String nama, int saldo) {
		String sql = "INSERT INTO "+TABLE+" ("
				+COL_ID+ ","
				+COL_NAMA+ ","
				+COL_SALDO+") VALUES ('"
				+id+"','"
				+nama+"',"
				+saldo+ ")";
		Connection konek = data.getConnection();
		try {
			Statement state = konek.createStatement();
			state.execute(sql);
			state.close();
			konek.close();
			System.out.println("Insert Berhasil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Terjadi Kesalahan "+e);
			e.printStackTrace();
		}
		
		
	}
	
	public int countData() {
		int res = 0;
		
		String sql = "Select COUNT("+COL_ID+") FROM "+TABLE;
		
		Connection konek = data.getConnection();
		Statement state;
		try {
			state = konek.createStatement();
			ResultSet result = state.executeQuery(sql);
			while(result.next()) {
				res = result.getInt(1);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	public String cariNasabah(String nama) {
		String res = "";
		
		String sql = "Select id FROM "+TABLE+" WHERE nama LIKE '%"+nama+"%'";
		
		Connection konek = data.getConnection();
		Statement state;
		try {
			state = konek.createStatement();
			ResultSet result = state.executeQuery(sql);
			while(result.next()) {
				res = result.getString(COL_ID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	public boolean cekSaldo(int nominal,String id) {
		
		boolean res = false;
		String sql = "Select saldo FROM "+TABLE+" WHERE id = '"+id+"'";
		int saldo = 0;
		Connection konek = data.getConnection();
		Statement state;
		try {
			state = konek.createStatement();
			ResultSet result = state.executeQuery(sql);
			while(result.next()) {
				saldo = result.getInt(COL_SALDO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (saldo > nominal) {
				res = true;
			}else {
				res= false;
			}
		}
		
		
		
		return res;
	}
	
public void updateSaldoKurang(String id,int nominal) {
		
		boolean res = false;
		String sql = "Select saldo FROM "+TABLE+" WHERE id = '"+id+"'";
		int saldo = 0;
		Connection konek = data.getConnection();
		Statement state;
		try {
			state = konek.createStatement();
			ResultSet result = state.executeQuery(sql);
			while(result.next()) {
				saldo = result.getInt(COL_SALDO);
			}
			saldo = saldo - nominal;
			String sql_min = "UPDATE saldo SET saldo = "+saldo+" WHERE id = '"+id+"'";
			state.execute(sql_min);
			state.close();
			konek.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

public void updateSaldoTambah(String id,int nominal) {
	
	boolean res = false;
	String sql = "Select saldo FROM "+TABLE+" WHERE id = '"+id+"'";
	
	int saldo = 0;
	Connection konek = data.getConnection();
	Statement state;
	try {
		state = konek.createStatement();
		ResultSet result = state.executeQuery(sql);
		while(result.next()) {
			saldo = result.getInt(COL_SALDO);
		}
		saldo = saldo + nominal;
		String sql_min = "UPDATE saldo SET saldo = "+saldo+" WHERE id = '"+id+"'";
		state.execute(sql_min);
		state.close();
		konek.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

public void updateKreditTambah(String id,int nominal) {
	
	boolean res = false;
	String sql = "Select total_kredit FROM "+TABLE+" WHERE id = '"+id+"'";
	
	int saldo = 0;
	Connection konek = data.getConnection();
	Statement state;
	try {
		state = konek.createStatement();
		ResultSet result = state.executeQuery(sql);
		while(result.next()) {
			saldo = result.getInt(COL_KREDIT);
		}
		saldo = saldo + nominal;
		String sql_min = "UPDATE saldo SET total_kredit = "+saldo+" WHERE id = '"+id+"'";
		state.execute(sql_min);
		state.close();
		konek.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

public void updateKreditKurang(String id,int nominal) {
	
	boolean res = false;
	String sql = "Select total_kredit FROM "+TABLE+" WHERE id = '"+id+"'";
	
	int saldo = 0;
	Connection konek = data.getConnection();
	Statement state;
	try {
		state = konek.createStatement();
		ResultSet result = state.executeQuery(sql);
		while(result.next()) {
			saldo = result.getInt(COL_KREDIT);
		}
		saldo = saldo - nominal;
		String sql_min = "UPDATE saldo SET total_kredit = "+saldo+" WHERE id = '"+id+"'";
		state.execute(sql_min);
		state.close();
		konek.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

}
