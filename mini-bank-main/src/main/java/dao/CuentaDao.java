package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidades.Cliente;
import entidades.Cuenta;

public class CuentaDao {

	private static ConfigHibernate ch;
	
	
	public CuentaDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConfigHibernate getCh() {
		return ch;
	}


	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}


	public Cuenta getCuenta(int id) {
		Session session = ch.getConexion();		  
		return (Cuenta)session.get(Cuenta.class, id);
	}
	
	public static List<Cuenta> getListaCuentasByCliente(int cliente_id) // Ejemplo de metodo para traer datos por HQL
	{	   
		Session session = ch.getConexion();
		String hql = "FROM Cuenta WHERE id_cliente = :id_cliente";
		Query q = session.createQuery(hql);
		q.setParameter("id_cliente", cliente_id);
		List<Cuenta> listaCuentas = q.list();    
		
		for (Cuenta _cue : listaCuentas ) {
		    System.out.println(_cue.toString());
		}

		return listaCuentas; 
	}
	
    public Cuenta getCuentaByCBU(String cbu) {
		Session session = ch.getConexion();		 
		String hql = "FROM Cuentas WHERE cbu = :cbu";
		Query q = session.createQuery(hql);
		q.setParameter("cbu", cbu);
		
		Cuenta cuenta = (Cuenta) q.uniqueResult();
		
		return cuenta;
		
	}
    
    public List<Cuenta> getListaCuentasByTipoCuentaAndClienteId(int tipo_cuenta, int cliente_id, int current_num_cuenta) {
		Session session = ch.getConexion();
    	// Trae todas las cuentas que sean del cliente que tengan el mismo tipo de cuenta, y exceptua la cuenta de la que se va a hacer la transferencia
		String hql = "FROM Cuenta WHERE id_cliente = :cliente_id AND tipo_cuenta = :tipo_cuenta AND num_cuenta != :current_cuenta_id";
		Query q = session.createQuery(hql);
		
		q.setParameter("cliente_id", cliente_id);
		q.setParameter("tipo_cuenta", tipo_cuenta);
		q.setParameter("current_cuenta_id", current_num_cuenta);
		System.out.println(q.getQueryString());
		List<Cuenta> listaCuentas = q.list();    
		
		for (Cuenta _cue : listaCuentas ) {
		    System.out.println(_cue.toString());
		}
 		return listaCuentas;
		
	}
}