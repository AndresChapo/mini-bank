package service;

import dao.ClienteDao; 
import entidades.Cliente;
import serviceInterfaz.ClienteServiceInterfaz;

public class ClienteService implements ClienteServiceInterfaz {
	
	private ClienteDao clienteDao = null;
	
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

}
