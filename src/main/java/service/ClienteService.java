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
    
    public Cliente parametrizarCliente(String id, String nombre, String apellido, String dni,
			String fecha, char sexo, String provincia, String localidad,
			String domicilio, String telefono, String correo) {
    	
    	Cliente c = getCliente(Integer.parseInt(id));
    	
    	if (nombre != null) c.setNombre(nombre);
    	if (apellido != null) c.setApellido(apellido);
    	if (dni != null) c.setDni(dni);
    	if (fecha != null) c.setFecha_nacimiento(fecha);
    	if (sexo != 0) c.setSexo(sexo);
    	if (provincia != null) c.setProvincia(provincia);
    	if (localidad != null) c.setLocalidad(localidad);
    	if (domicilio != null) c.setDireccion(domicilio);
    	if (telefono != null) c.setTelefono(telefono);
    	if (correo != null) c.setEmail(correo);
    	
		return c; 
    }
}
