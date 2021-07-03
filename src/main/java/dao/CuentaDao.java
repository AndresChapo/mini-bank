package dao;

import entidades.Cuenta;

public class CuentaDao {

private ConfigHibernate h = new ConfigHibernate();

	
	public Cuenta getCuenta(int id) {
		  
		return h.getCuenta(id);
	}

	
}
