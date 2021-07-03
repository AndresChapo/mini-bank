package service;

import dao.MovimientoDao;
import entidades.Cuenta;
import serviceInterfaz.MovimientoServiceInterfaz;

public class MovimientoService implements MovimientoServiceInterfaz {

	private MovimientoDao movimientoDao = new MovimientoDao();
	private CuentaService cs = new CuentaService(); 

	public void generarMovimientos(String TXTadepositar, String TXTcbu, String TXTCuentaOrigenID) {
		
		Cuenta _cuentaOrigen  = getCuentaByCBU(TXTcbu);
		Cuenta _cuentaDestino = cs.getCuenta(Integer.parseInt(TXTCuentaOrigenID));
		
		
		
	}
	
	
	public Cuenta getCuentaByCBU(String cbu) {
		
		// todo usar bean?
		Cuenta cuenta = new Cuenta();
		
		
		
		return cuenta;
		
	}

	
}
