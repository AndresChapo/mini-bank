package serviceInterfaz;

import java.util.List;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;

public interface CuentaServiceInterfaz {


	public CuentaDao getCuentaDao();

	public void setCuentaDao(CuentaDao cuentaDao); 

	public Cuenta getCuenta(int id);
	
	public List<Cuenta> getListaCuentasByUsuario(Usuario usuario);
	
	public List<Cuenta> getListaCuentasByCliente(int cliente_id);

	
	public List<Cuenta> getListaCuentasByTipoCuentaAndCliente (Tipo_cuenta tipo_cuenta, Cliente cliente, int current_num_cuenta);
	
	public boolean checkCuentaByUsuario(Usuario usuarioLogueado, int num_cuenta);
	
	public Cuenta getCuentaByCBU(String cbu);

	public boolean modificarCuenta(Cuenta cuenta);
 
	public boolean GuardarCuenta(Cuenta cuentaNueva);
	      
	public String ObtenerUltimoCBU();
	     
    public boolean eliminarCuenta(Cuenta cuentaEliminar);
	
}
