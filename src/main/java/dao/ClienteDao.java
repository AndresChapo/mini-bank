package dao;
 
import daoInterfaz.ClienteDaoInterfaz;
import entidades.Cliente;

public class ClienteDao implements ClienteDaoInterfaz {
	
	private daoHibernate daoH = new daoHibernate();

	
	public void modificarCliente(Cliente cliente) {
		
		 daoHibernate.UpdateGenerico(cliente);

	}

}
