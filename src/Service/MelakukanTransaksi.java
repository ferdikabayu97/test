package Service;

import java.sql.Date;
import java.util.Scanner;

import DAO.SaldoDAO;
import DAO.TransaksiDAO;

public class MelakukanTransaksi {

	SaldoDAO nasabah = new SaldoDAO();
	TransaksiDAO transaksi = new TransaksiDAO();
	
	
	public void transaksi() {
		String id;
		int nominal;
		String jenis;
		Scanner type = new Scanner(System.in);
		
		System.out.println("Cari Nasabah :");
		String nama_nasabah = type.nextLine();
		
		id = nasabah.cariNasabah(nama_nasabah);
		
		System.out.println("Pilih Jenis Transaksi :");
		System.out.println("1. Debit");
		System.out.println("2. Kredit");
		String a = type.nextLine();
		System.out.println("Masukan Besaran Nominal Transaksi : ");
		nominal = type.nextInt();
		
		boolean ket = nasabah.cekSaldo(nominal, id);
		
		if(a.equals("1")) {
			jenis = "Debit";
			if (ket) {
				transaksi.insertTransaksi(id, nominal, jenis);
				nasabah.updateSaldoKurang(id, nominal);
			}else {
				System.out.println("Saldo Anda Tidak Cukup");
			}
		}else if(a.equals("2")) {
			jenis = "Kredit";
			transaksi.insertTransaksi(id, nominal, jenis);
			nasabah.updateKreditTambah(id, nominal);
			
		}else {
			System.out.println("Pilih salah satu dari dua");
		}
		
		
		
		
	}
	
	public void pengisianSaldo() {
		String id;
		int nominal;
		Scanner type = new Scanner(System.in);
		
		System.out.println("Cari Nasabah :");
		String nama_nasabah = type.nextLine();
		
		id = nasabah.cariNasabah(nama_nasabah);
		System.out.println("Masukan Nama Nasabah : ");
		String nama = type.nextLine();
	id = nasabah.cariNasabah(nama);
		
		System.out.println("Masukan Besaran Nominal Pengisian : ");
		nominal = type.nextInt();
		
		nasabah.updateSaldoTambah(id, nominal);
		
		
	}
	
	public void pembayaranKredit() {
		String id;
		int nominal;
		Scanner type = new Scanner(System.in);
		
		System.out.println("Cari Nasabah :");
		String nama_nasabah = type.nextLine();
		
		id = nasabah.cariNasabah(nama_nasabah);
		System.out.println("Masukan Nama Nasabah : ");
		String nama = type.nextLine();
	id = nasabah.cariNasabah(nama);
		
		System.out.println("Masukan Besaran Nominal Pengisian : ");
		nominal = type.nextInt();
		
		nasabah.updateKreditKurang(id, nominal);
		
		
	}
	
}
