package service;

import dao.CuentaDao;
import entidades.Cuenta;

public class CuentaService {
	
	private CuentaDao cuentaDao = new CuentaDao();

	
	public Cuenta getCuenta(int id) {
		 
		return cuentaDao.getCuenta(id);
	}

}
