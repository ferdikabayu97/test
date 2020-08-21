package Model;

import java.sql.Date;

public class Transaksi {
	String id;
	int nominal;
	String jenis;
	Date tanggal;
	public Transaksi(String id, int nominal, String jenis, Date tanggal) {
		super();
		this.id = id;
		this.nominal = nominal;
		this.jenis = jenis;
		this.tanggal = tanggal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	
	
	

}
