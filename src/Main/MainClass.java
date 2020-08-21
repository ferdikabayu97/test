package Main;

import java.util.Scanner;

import Service.CreateDBService;
import Service.MelakukanTransaksi;
import Service.MenambahNasabahService;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CreateDBService db = new CreateDBService();
//		db.createTableDB();
		Scanner type = new Scanner(System.in); 
		
		MenambahNasabahService tambahNasabah = new MenambahNasabahService();
		MelakukanTransaksi transaksi = new MelakukanTransaksi();
		
		
		System.out.println("Selamat Datang Di BANK");
		System.out.println("Silahkan pilih transaksi anda : ");
		System.out.println("1. Menambah Nasabah :");
		System.out.println("2. Melakukan Transaksi Penarikan :");
		System.out.println("3. Melakukan Isi Saldo :");
		System.out.println("4. Melakukan pembayaran Kredit :");
		System.out.println("Silahkan pilih :");
		String a = type.nextLine();
		
		switch(a) {
		  case "1":
		    tambahNasabah.tambahNasabah();
		    break;
		  case "2":
		    transaksi.transaksi();
		    break;
		  case "3":
			transaksi.pengisianSaldo();
		break;
		  case "4":
			  transaksi.pembayaranKredit();
			break;
		  default:
		    System.out.println("Masukan pilihan yang ada");
		}
		
		
		
	}

}
