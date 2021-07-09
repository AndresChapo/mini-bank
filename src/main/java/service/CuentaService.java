package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ClienteDao;
import dao.CuentaDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;

public class CuentaService {
	
	private static CuentaDao cuentaDao;
	
	public CuentaDao getCuentaDao() {
		return cuentaDao;
	}

	public void setCuentaDao(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}


	public Cuenta getCuenta(int id) {
		 
		return cuentaDao.getCuenta(id);
	}
	
	public static List<Cuenta> getListaCuentasByUsuario(Usuario usuario)
	{	   
		ClienteDao clienteService = new ClienteDao();
		Cliente _cliente = clienteService.getClienteByUsuario(usuario);

		List<Cuenta> listaCuentas = cuentaDao.getListaCuentasByCliente(_cliente.getId());

		return listaCuentas; 
	}
	
	public static List<Cuenta> getListaCuentasByTipoCuentaAndCliente (Tipo_cuenta tipo_cuenta, Cliente cliente, int current_num_cuenta){
		return cuentaDao.getListaCuentasByTipoCuentaAndClienteId(tipo_cuenta, cliente, current_num_cuenta);
	}
	
	public static boolean checkCuentaByUsuario(Usuario usuarioLogueado, int num_cuenta) {
		return cuentaDao.checkCuentaIsFromUsuarioLogueado(usuarioLogueado, num_cuenta);
	}
	
	public Cuenta getCuentaByCBU(String cbu) {
		return cuentaDao.getCuentaByCBU(cbu);

	}
	
	public boolean modificarCuenta(Cuenta cuenta) {

		cuentaDao.modificarCuenta(cuenta); 
		return true;
	}

	
}
