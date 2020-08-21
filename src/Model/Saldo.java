package Model;

public class Saldo {
	String id;
	String nama;
	int saldo;
	public Saldo(String id, String nama, int saldo) {
		super();
		this.id = id;
		this.nama = nama;
		this.saldo = saldo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
