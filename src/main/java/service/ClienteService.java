package service;

import dao.ClienteDao; 
import entidades.Cliente;
import serviceInterfaz.ClienteServiceInterfaz;

public class ClienteService implements ClienteServiceInterfaz {
	
	private ClienteDao clienteDao = new ClienteDao();

	
	public boolean modificarCliente(Cliente cliente) {

		clienteDao.modificarCliente(cliente);
		
		return true;
	}
	
	public boolean eliminarCliente(Cliente cliente) {

		clienteDao.eliminarCliente(cliente);
		
		return true;
	}

}
