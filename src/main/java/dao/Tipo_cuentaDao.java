package dao;

import org.hibernate.Session;

import daoInterfaz.Tipo_cuentaDaoInterfaz;
import entidades.Cuenta;
import entidades.Tipo_cuenta;

public class Tipo_cuentaDao implements Tipo_cuentaDaoInterfaz {

	private ConfigHibernate ch;

	public Tipo_cuentaDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}
	
	@Override
	public Tipo_cuenta getTipoCuenta(int id) {
		Session session = ch.getConexion();		  
		return (Tipo_cuenta)session.get(Tipo_cuenta.class, id);
	}

	
}
