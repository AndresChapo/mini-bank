package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ClienteDao;
import dao.CuentaDao;
import entidades.Cliente;
import entidades.Cuenta;
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
<<<<<<< HEAD
		Cliente _cliente = clienteService.getClienteByUsuario(usuario);
=======
		Cliente _cliente = clienteService.getClienteByUsuario(usuario_id);
>>>>>>> stash

		List<Cuenta> listaCuentas = cuentaDao.getListaCuentasByCliente(_cliente.getId());

		return listaCuentas; 
	}
	
	public static List<Cuenta> getListaCuentasByTipoCuentaAndClienteId (int tipo_cuenta, int cliente_id, int current_num_cuenta){
		return cuentaDao.getListaCuentasByTipoCuentaAndClienteId(tipo_cuenta, cliente_id, current_num_cuenta);
	}
	
	public static boolean checkCuentaByUsuario(Usuario usuarioLogueado, int num_cuenta) {
		return cuentaDao.checkCuentaIsFromUsuarioLogueado(usuarioLogueado, num_cuenta);
	}
	
	public Cuenta getCuentaByCBU(String cbu) {
		return cuentaDao.getCuentaByCBU(cbu);

	}

	
	
	//INICIO MODIFICACION REVOLLO
	//SIRVE PARA LLAMAR AL DAO Y PASARLE LOS DATOS DESDE EL CONTROLER
    public boolean GuardarCuenta(Cuenta cuentaNueva)
    {

		cuentaDao.guardarNuevaCuenta(cuentaNueva);
		return true;
	}
    
    //SIRVE PARA TRAER EL ULTIMO CBU EN LA BASE
    
    public String ObtenerUltimoCBU()
    {

		return  cuentaDao.obtenerUltimoCBU();
	}
    
    //FIN MODIFICACION REVOLLO
	
	
}
