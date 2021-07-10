package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import daoInterfaz.CuentaDaoInterfaz;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;

public class CuentaDao implements CuentaDaoInterfaz{

	private static ConfigHibernate ch;
	public static Session session;

	
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

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		ClienteDao.session = session;
	}

	@Override
	public Cuenta getCuenta(int id) {
		Session session = ch.getConexion();		  
		return (Cuenta)session.get(Cuenta.class, id);
	}
	
	public static List<Cuenta> getListaCuentasByCliente(int cliente_id) // Ejemplo de metodo para traer datos por HQL
	{	   
		Session session = ch.getConexion();
		String hql = "FROM Cuenta WHERE id_cliente = :id_cliente AND eliminado = 0";
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
		String hql = "FROM Cuenta WHERE cbu = :cbu";
		Query q = session.createQuery(hql);
		q.setParameter("cbu", cbu);
		
		Cuenta cuenta = (Cuenta) q.uniqueResult();
		
		return cuenta;
		
	}
    
    public List<Cuenta> getListaCuentasByTipoCuentaAndCliente(Tipo_cuenta tipo_cuenta, Cliente cliente_id, int current_num_cuenta) {
		Session session = ch.getConexion();
    	// Trae todas las cuentas que sean del cliente que tengan el mismo tipo de cuenta, y exceptua la cuenta de la que se va a hacer la transferencia
		String hql = "FROM Cuenta WHERE id_cliente = :cliente_id AND tipo_cuenta = :tipo_cuenta AND num_cuenta != :current_num_cuenta AND eliminado = 0";
		Query q = session.createQuery(hql);
		q.setParameter("cliente_id", cliente_id);
		q.setParameter("tipo_cuenta", tipo_cuenta);
		q.setParameter("current_num_cuenta", current_num_cuenta);
		List<Cuenta> listaCuentas = q.list();    
		
 		return listaCuentas;
		
	}

    @Override
	public void modificarCuenta(Cuenta cuenta) {
		session = ch.getConexion();
		session.beginTransaction();
    	session.update(cuenta);
    	session.getTransaction().commit();
	}

    
	public static boolean checkCuentaIsFromUsuarioLogueado(Usuario usuarioLogueado, int num_cuenta) // Ejemplo de metodo para traer datos por HQL
	{	   
		Session session = ch.getConexion();
		String hql = " FROM Cuenta as cue INNER JOIN cue.cliente as cli INNER JOIN cli.usuario as usr WHERE cue.num_cuenta = :num_cuenta AND cue.eliminado = 0";
		Query q = session.createQuery(hql);
		q.setParameter("num_cuenta", num_cuenta);
		Object[] resultado = (Object[]) q.uniqueResult();
		boolean esCuentaDelUsuarioLogueado = false;
		if(resultado != null) {
			//resultado[0] es Cuenta
			//resultado[1] es Cliente
			//resultado[2] es Usuario
			Usuario usr = (Usuario) resultado[2];
			if(usr.getId() == usuarioLogueado.getId()) {
				esCuentaDelUsuarioLogueado = true;
			}
		}
		
		return esCuentaDelUsuarioLogueado;
		
	}

    
    

    //MODIFICACION REVOLLO INICIO
    
    //AGREGO FUNCION PARA CREAR UNA CUENTA NUEVA
    
    public void guardarNuevaCuenta (Cuenta cuentaNueva)
    {
    	Session session = ch.getConexion();
		session.beginTransaction();
    	session.save(cuentaNueva);
    	session.getTransaction().commit();
    }
    
    //AGREGO FUNCION PARA TRAER EL ULTIMO CBU EN LA BASE
    
    public String obtenerUltimoCBU() {
    	Session session = ch.getConexion();		 
		String hql = "SELECT c.cbu FROM Cuenta c ORDER BY c.num_cuenta DESC";
		Query q = session.createQuery(hql);
		q.setMaxResults(1);
		String Cbu =  (String)q.uniqueResult();
		return Cbu;
	}
    
    //AGREGAR FUNCION PARA QUE ELIMINE UNA CUENTA
    
     public void eliminarCuenta(Cuenta cuentaEliminar) {
		
		
		Integer num_cuenta = cuentaEliminar.getNum_cuenta();
		
		session = ch.getConexion();
		session.beginTransaction();
    	
		String hql = "UPDATE Cuenta SET eliminado = true WHERE num_cuenta = :num_cuenta ";
		
		Query q = session.createQuery(hql);
		q.setParameter("num_cuenta", num_cuenta);
	    q.executeUpdate();
	    
		session.getTransaction().commit();
	}
    
    //MODIFICACION REVOLLO FIN


	
    

}
