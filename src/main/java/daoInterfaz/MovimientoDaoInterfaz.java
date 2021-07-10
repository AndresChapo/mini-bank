package daoInterfaz;

import entidades.Cuenta;
import entidades.Movimiento;

public interface MovimientoDaoInterfaz {

	public void agregarMovimiento (Cuenta cuenta, String detalle, float importe);
	
	public void modificarMovimiento(Movimiento movimiento);
	
	public void eliminarMovimiento(Movimiento movimiento);
	
	public Movimiento traerMovimiento(int id);

}
