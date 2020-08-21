package Service;

import java.util.Scanner;

import DAO.SaldoDAO;

public class MenambahNasabahService {

	public void tambahNasabah() {
		String id = "ID-";
		String nama;
		int saldo;
		Scanner type = new Scanner(System.in);
		SaldoDAO classSaldo = new SaldoDAO();
		
		System.out.println("MASUKAN NAMA NASABAH : ");
		nama = type.nextLine();
		
		int urutan = classSaldo.countData()+1;
		
		for(int a = Integer.toString(urutan).length()+3;a>=5;a++) {
			id = id+"0";
		}
		id = id+urutan;
		
		System.out.println("MASUKAN SALDO NASABAH : ");
		saldo = type.nextInt();
		
		classSaldo.insertNasabah(id, nama, saldo);
		type.close();
		
		
	}
	
	
	
	
}
