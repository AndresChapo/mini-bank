package dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daoInterfaz.ClienteDaoInterfaz;
import entidades.Cliente;

public class ClienteDao implements ClienteDaoInterfaz {
	
	private static ConfigHibernate ch;
	public static Session session;
	
 
	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		ClienteDao.session = session;
	}

	public void modificarCliente(Cliente cliente) {
		this.UpdateGenerico(cliente); 
	}
	
	public void eliminarCliente(Cliente cliente) {
    	session = ch.getConexion();
		String hql = "UPDATE Cliente SET eliminado = true WHERE id = :id";
		Query q = session.createQuery(hql);
		q.setParameter("id", cliente.getId());
		int r = q.executeUpdate(); 
	}
  	
	
	public void UpdateGenerico(Object o) {
    	session = ch.getConexion();
    	session.update(o);
    }
	

    public Cliente getCliente(int id)
	{	   
		return (Cliente)session.get(Cliente.class, id); 
	}
    
    public static List<Cliente> getListaClientes() // Ejemplo de metodo para traer datos por HQL
	{	   
    	session = ch.getConexion();
    	Criteria cr = session.createCriteria(Cliente.class);
    	List<Cliente> results = cr.list();    	
    	return results;
	}

    public Cliente getClienteByUsuarioId(int id_usuario) {
    	session = ch.getConexion();    	
		String hql = "FROM Cliente WHERE id_usuario = :id_usuario";
		
		Query q = session.createQuery(hql);
		q.setParameter("id_usuario", id_usuario);
		
		Cliente _cliente = (Cliente) q.uniqueResult();
		
		return _cliente;
		
	}
}
