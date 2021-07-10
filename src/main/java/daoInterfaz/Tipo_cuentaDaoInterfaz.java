package daoInterfaz;
 
import org.hibernate.Session;

import entidades.Tipo_cuenta;
import entidades.Usuario;

public interface Tipo_cuentaDaoInterfaz {
	
	public Tipo_cuenta getTipoCuenta(int id);

}
