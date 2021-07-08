package service;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioService {

	static UsuarioDao usuarioDao;

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	public static Usuario getUsuarioByNombreUsuario(String usuario) // Ejemplo de metodo para traer datos por HQL
	{	   
		Usuario _usuario = (Usuario) usuarioDao.getUsuarioByNombreUsuario(usuario); 
		return _usuario; 
	}
}
