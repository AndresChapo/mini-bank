package dao;
 
import daoInterfaz.ClienteDaoInterfaz;
import entidades.Cliente;

public class ClienteDao implements ClienteDaoInterfaz {
	
	private ConfigHibernate h = new ConfigHibernate();

	
	public void modificarCliente(Cliente cliente) {
		
		 h.UpdateGenerico(cliente);

	}

 
	public void eliminarCliente(Cliente cliente) {
		 
	}

}
