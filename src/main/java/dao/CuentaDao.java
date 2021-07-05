package dao;


import entidades.Cuenta;

public class CuentaDao {

	private ConfigHibernate ch;
	
	
	public CuentaDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConfigHibernate getCh() {
		return ch;
	}


	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}


	public Cuenta getCuenta(int id) {
		  
		return ch.getCuenta(id);
	}

	
}
