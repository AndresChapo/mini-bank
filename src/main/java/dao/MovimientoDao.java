package dao;

import java.sql.Date;

import entidades.Movimiento;

public class MovimientoDao {

	private ConfigHibernate h = new ConfigHibernate();
	
	
	
	public void agregarMovimiento (Integer nroCuenta, String detalle, float importe) {
		
		if(detalle.isEmpty()) {
			detalle = "";
		}
		//TODO: Cambiar por date.
		// Date _hoy = new Date();
		
		String hoy = "hoy";
		Movimiento _m = new Movimiento(nroCuenta, hoy , detalle, importe);
	
		h.agregarMovimiento(_m);
	}

	
}
