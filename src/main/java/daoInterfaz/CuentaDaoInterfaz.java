package daoInterfaz;

import entidades.Cuenta;

public interface CuentaDaoInterfaz {

	public void modificarCuenta(Cuenta cuenta);	
	
	public Cuenta getCuenta(int id);
	
    public void guardarNuevaCuenta (Cuenta cuentaNueva);
	
	public void eliminarCuenta(Cuenta cuenta);	
	
}
