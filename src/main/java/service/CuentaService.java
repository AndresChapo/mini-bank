package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ClienteDao;
import dao.CuentaDao;
import entidades.Cliente;
import entidades.Cuenta;

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
	
	public static List<Cuenta> getListaCuentasByUsuario(int usuario_id)
	{	   
		ClienteDao clienteService = new ClienteDao();
		Cliente _cliente = clienteService.getClienteByUsuarioId(usuario_id);

		List<Cuenta> listaCuentas = cuentaDao.getListaCuentasByCliente(_cliente.getId());

		return listaCuentas; 
	}
	
	public static List<Cuenta> getListaCuentasByTipoCuentaAndClienteId (int tipo_cuenta, int cliente_id, int current_num_cuenta){
		return cuentaDao.getListaCuentasByTipoCuentaAndClienteId(tipo_cuenta, cliente_id, current_num_cuenta);
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
