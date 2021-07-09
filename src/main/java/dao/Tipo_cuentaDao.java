package dao;

import org.hibernate.Session;

import entidades.Cuenta;
import entidades.Tipo_cuenta;

public class Tipo_cuentaDao {

	private ConfigHibernate ch;

	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	
	public Tipo_cuenta getTipoCuenta(int id) {
		Session session = ch.getConexion();		  
		return (Tipo_cuenta)session.get(Cuenta.class, id);
	}

	
}
