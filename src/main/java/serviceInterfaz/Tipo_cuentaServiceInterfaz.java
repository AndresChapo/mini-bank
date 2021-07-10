package serviceInterfaz;

import java.util.List;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import dao.Tipo_cuentaDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;
import service.Tipo_cuentaService;

public interface Tipo_cuentaServiceInterfaz {


	public Tipo_cuentaDao getTipo_cuentaDao();

	public void setTipo_cuentaDao(Tipo_cuentaDao tipo_cuentaDao);
	
	public Tipo_cuenta getTipoCuenta(int id);
 
	
}
