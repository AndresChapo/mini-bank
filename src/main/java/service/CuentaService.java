package service;

import dao.CuentaDao;
import entidades.Cuenta;

public class CuentaService {
	
	private CuentaDao cuentaDao;
	
	public CuentaDao getCuentaDao() {
		return cuentaDao;
	}

	public void setCuentaDao(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}


	public Cuenta getCuenta(int id) {
		 
		return cuentaDao.getCuenta(id);
	}

}
