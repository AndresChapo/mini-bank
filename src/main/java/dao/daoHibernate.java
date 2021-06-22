package dao;

import org.hibernate.Session;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Usuario;

public class daoHibernate {
	public static void Add(Cuenta cuenta)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	    session.beginTransaction();
	    session.save(cuenta);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	public static void Add(Cliente cliente)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	    session.beginTransaction();
	    session.save(cliente);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void Add(Usuario user)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	    session.beginTransaction();
	    session.save(user);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static Usuario ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,id);
        
        config.cerrarSession();
        
        return usuario;
	}
	
	public static void Update(Usuario usuario)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public static void Delete(Usuario usuario) //Este usuario tiene que venir cargado el ID del usuario que se quiere eliminar
	{
		
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();

	}
}
