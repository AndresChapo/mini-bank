package daoInterfaz;

import entidades.Cliente;

public interface ClienteDaoInterfaz {
	
	public void modificarCliente(Cliente cliente);
	
	public void eliminarCliente(Cliente cliente);
	
	public Cliente getCliente(int id);
	
	//public Cliente getClienteByUsuarioId(int id_usuario);

}
