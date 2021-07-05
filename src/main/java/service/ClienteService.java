package service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import dao.ClienteDao; 
import entidades.Cliente;
import serviceInterfaz.ClienteServiceInterfaz;

public class ClienteService implements ClienteServiceInterfaz {
	
	private static ClienteDao clienteDao = null;
	
	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public boolean modificarCliente(Cliente cliente) {

		clienteDao.modificarCliente(cliente);
		
		return true;
	}
	
	public boolean eliminarCliente(Cliente cliente) {

		clienteDao.eliminarCliente(cliente);
		
		return true;
	}
	

	public Cliente getCliente(int id) {
		 
		return clienteDao.getCliente(id);
	}
	
    public static List<Cliente> getListaClientes() // Ejemplo de metodo para traer datos por HQL
	{	   
    	return clienteDao.getListaClientes();
	}
    
    public static Cliente getClienteByUsuarioId(int id_usuario) {
  
		return clienteDao.getClienteByUsuarioId(id_usuario);
		
	}
}
