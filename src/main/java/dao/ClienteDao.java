package dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.cj.xdevapi.Expression;

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
		session = ch.getConexion();
		session.beginTransaction();
    	session.update(cliente);
    	session.getTransaction().commit();
	}
	
	
	public void eliminarCliente(Cliente cliente) {
		
		System.out.println("sasasdsada");
		Integer id = cliente.getId();
		session = ch.getConexion();
		session.beginTransaction();
    	session = ch.getConexion();
		String hql = "UPDATE Cliente SET eliminado = true WHERE id = :id";
		Query q = session.createQuery(hql);
		q.setParameter("id", id);
		int r = q.executeUpdate();  
		session.getTransaction().commit();
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
    	cr.add(Restrictions.eq("eliminado", false));
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
