package serviceInterfaz;

import entidades.Cliente;

public interface ClienteServiceInterfaz {

	public boolean modificarCliente(Cliente cliente);

	public boolean eliminarCliente(Cliente cliente);
	
	public Cliente getCliente(int id);
	
}
