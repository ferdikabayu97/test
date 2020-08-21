package Service;

import DAO.SaldoDAO;
import DAO.TransaksiDAO;

public class CreateDBService {

	public void createTableDB() {
		TransaksiDAO transaksi = new TransaksiDAO();
		SaldoDAO saldo = new SaldoDAO();
		
		saldo.createTableSaldo();
		transaksi.createTableTransaksi();
	}
	
}
