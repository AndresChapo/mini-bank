package dao;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;

import entidades.Cuenta;
import entidades.Movimiento;

public class MovimientoDao {

	private ConfigHibernate ch;
	private Movimiento movimiento;
	
	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

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

		movimiento.setCliente(cuenta);
		movimiento.setDetalle(detalle);
		movimiento.setImporte(importe);
		movimiento.setFecha(hoy);
		
		session.beginTransaction();
		session.save(movimiento);
    	session.getTransaction().commit();

    	
    }
	
}
