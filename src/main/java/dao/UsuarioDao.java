package dao;

import org.hibernate.Query;
import org.hibernate.Session;

import entidades.Usuario;

public class UsuarioDao {

	private static ConfigHibernate ch;
	
	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	public static Usuario getUsuarioByNombreUsuario(String usuario) // Ejemplo de metodo para traer datos por HQL
	{	   
		String hql = "FROM Usuario WHERE nombre = :usuario";
		Session session = ch.getConexion();
		Query q = session.createQuery(hql);
		q.setParameter("usuario", usuario);
		Usuario _usuario = (Usuario) q.uniqueResult();
		System.out.println(_usuario.toString());
		
		return _usuario; 
	}

	public static Usuario traerUsuario(int id)
	{	   
		Session session = ch.getConexion();
		return (Usuario)session.get(Usuario.class,id); 
	}
}
