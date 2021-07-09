package service;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioService {

	static UsuarioDao usuarioDao;
	static Usuario usuarioLogueado;

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public static void setUsuarioLogueado(Usuario usuarioLogueado) {
		UsuarioService.usuarioLogueado = usuarioLogueado;
	}

	public static Usuario getUsuarioByNombreUsuario(String usuario) // Ejemplo de metodo para traer datos por HQL
	{	   
		Usuario _usuario = (Usuario) usuarioDao.getUsuarioByNombreUsuario(usuario); 
		return _usuario; 
	}
	
	
	//INICIO MODIFICACION REVOLLO
    //SIRVE PARA LLAMAR AL DAO Y PASARLE LOS DATOS DESDE EL CONTROLER
    public boolean GuardarUsuario(Usuario usuarioNuevo)
    {

		usuarioDao.guardarNuevoUsuario(usuarioNuevo);
		return true;
	}
    
    //FIN MODIFICACION REVOLLO

	
	
	
}
