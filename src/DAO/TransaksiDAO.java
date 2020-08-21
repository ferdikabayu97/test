package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransaksiDAO {

	String TABLE = "transaksi";
	String COL_ID = "id";
	String COL_NOMINAL = "nominal";
	String COL_JENIS =  "jenis";
	String COL_TANGGAL =  "tanggal";
	
	DataSource data = new DataSource();
	
	public void createTableTransaksi() {
		String sql ="CREATE TABLE IF NOT EXISTS transaksi (id VARCHAR(5) NOT null,nominal  INT NOT NULL,jenis VARCHAR(10) NOT NULL,tanggal TIMESTAMP NOT NULL, CONSTRAINT daftar_fk_1 FOREIGN KEY (id) REFERENCES saldo(id) ON DELETE RESTRICT ON UPDATE CASCADE)";
		
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
	
	public void insertTransaksi(String id, int nominal, String jenis) {
		String sql = "INSERT INTO "+TABLE+" ("
				+COL_ID+ ","
				+COL_NOMINAL+ ","
				+COL_JENIS+ ","
				+COL_TANGGAL+") VALUES ('"
				+id+"','"
				+nominal+"','"
				+jenis+ "', NOW() )";
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
	
	
	
}
