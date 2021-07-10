package serviceInterfaz;

import entidades.Cliente;

public interface ClienteServiceInterfaz {

	public boolean modificarCliente(Cliente cliente);

	public boolean eliminarCliente(Cliente cliente);
	
	public Cliente getCliente(int id);
	
	public Cliente parametrizarCliente(String id, String nombre, String apellido, String dni,
			String fecha, char sexo, String provincia, String localidad,
			String domicilio, String telefono, String correo);
	
	public boolean validarCliente(String id, String nombre, String apellido, String dni,
			String fecha, char sexo, String provincia, String localidad,
			String domicilio, String telefono, String correo);
	
}
