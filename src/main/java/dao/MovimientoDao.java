package dao;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;

import entidades.Cuenta;
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

	public void agregarMovimiento (Cuenta cuenta, String detalle, float importe) {
    	Session session = ch.getConexion();
		if(detalle.isEmpty()) {
			detalle = "";
		}
		
		Date hoy = Date.valueOf(LocalDate.now());

		Movimiento _movimiento = new Movimiento(cuenta, hoy , detalle, importe);
		session.beginTransaction();
		session.save(_movimiento);
    	session.getTransaction().commit();

    	
    }
	
}
