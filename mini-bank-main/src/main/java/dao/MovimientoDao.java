package dao;

import java.sql.Date;

import org.hibernate.Session;

import entidades.Movimiento;

public class MovimientoDao {

	private ConfigHibernate ch;
	
	public MovimientoDao() {
		super();
	}
	
	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	public void agregarMovimiento (Integer nroCuenta, String detalle, float importe) {
    	Session session = ch.getConexion();
		if(detalle.isEmpty()) {
			detalle = "";
		}
		//TODO: Cambiar por date.
		// Date _hoy = new Date();
		
		String hoy = "hoy";
		Movimiento _movimiento = new Movimiento(nroCuenta, hoy , detalle, importe);

    	session.save(_movimiento);
    }
	
}
