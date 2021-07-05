package dao;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daoInterfaz.ClienteDaoInterfaz;
import entidades.Cliente;

public class ClienteDao implements ClienteDaoInterfaz {
	
	private ConfigHibernate ch = null;
	public static Session session = null;
	
 
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
		   
			String hql = "UPDATE Cliente SET eliminado = true WHERE id = :id";
			Query q = session.createQuery(hql);
			q.setParameter("id", cliente.getId());
			int r = q.executeUpdate(); 
	}
  	
	
	public void UpdateGenerico(Object o) {
    	session.update(o);
    }
	

    public Cliente getCliente(int id)
	{	   
		return (Cliente)session.get(Cliente.class, id); 
	}
    
    

}
