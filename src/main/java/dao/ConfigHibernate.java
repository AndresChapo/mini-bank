package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Tipo_cuenta;
import entidades.Usuario;

public class ConfigHibernate {

	private SessionFactory sessionFactory;
	public static Session session;

	public ConfigHibernate()
	{
		Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public Session abrirConexion()
	{
		session=sessionFactory.openSession();
		altaDatosEjemplo();
		return session;
	}
	public Session getConexion()
	{
		return session;
	}
	public void cerrarSession()
	{
		session.close();
		cerrarSessionFactory();
	}
	
	
	public void cerrarSessionFactory()
	{
		sessionFactory.close();
	}
	
	public void altaDatosEjemplo()
	{
		
		Tipo_cuenta t_cuenta_pesos = new Tipo_cuenta("Caja de ahorro en pesos");
		Tipo_cuenta t_cuenta_dolares = new Tipo_cuenta("Caja de ahorro en d�lares");
	
		Usuario user1 = new Usuario("Nico","Radeon24",true);
		Usuario user2 = new Usuario("Andy","F8-F8-28-B6-71-F3",true);
		Usuario user3 = new Usuario("Nahu","1234",true);
		Usuario user4 = new Usuario("Bruno","adminadmin",true);
		Usuario user5 = new Usuario("Pedro","Armenia1954",false);
		Usuario user6 = new Usuario("Juan","L1br0sGr4t1s",false);
		Usuario user7 = new Usuario("Carlos86","djkd9d8dje7",false);
		Usuario user8 = new Usuario("AlbertoAlberto","hastaLaVictoria",false);
		Usuario user9 = new Usuario("Asia","AsiaMisticaMichone",false);
		Usuario user10 = new Usuario("Micaela19","pokemon",false);

		Cliente cliente1 = new Cliente(1,"11222333", "Nicolas", "Slemenson ", "1234-3747", "Nicolas@hotmail.com", 'M', "Argentino", "Calle real 234", "CABA", "Buenos Aires", "1980-10-12");
		Cliente cliente2 = new Cliente(2,"34717846", "Andy", "Argento", "1234-1234", "Andy@hotmail.com", 'M', "Argentino", "9 de Julio falsa 23", "San Fernando", "Buenos Aires", "1988-11-12");
		Cliente cliente3 = new Cliente(3,"40223343", "Nahu", "Revollo", "6345-3478", "Nahu@hotmail.com", 'M', "Argentino", "Rivadavia 4678", "CABA", "Buenos Aires", "1986-10-15");
		Cliente cliente4 = new Cliente(4,"42233843", "Bruno", "Daglio", "8678-2345", "Bruno@hotmail.com", 'M', "Argentino", "Bravo 456", "Bolivar", "Buenos Aires", "1981-12-12");
		Cliente cliente5 = new Cliente(5,"32825303", "Pedro", "Lerose", "4586-7092", "Pedro@hotmail.com", 'M', "Peruano", "Callao 897", "CABA", "Buenos Aires", "1983-05-25");
		Cliente cliente6 = new Cliente(6,"32996348", "Juan", "Gomez", "4845-3557", "Juan@hotmail.com", 'M', "Argentino", "Corrientes 6345", "CABA", "Buenos Aires", "1985-07-11");
		Cliente cliente7 = new Cliente(7,"42263933", "Carlos", "Gonzalez", "3456-2447", "Carlos86@hotmail.com", 'M', "Chileno", "Malvinas 234", "CABA", "Buenos Aires", "19870-11-15");
		Cliente cliente8 = new Cliente(8,"20283042", "Alberto", "Rodriguez", "6897-9774", "AlbertoAlberto@hotmail.com", 'M', "Argentino", "Frias 27", "CABA", "Buenos Aires", "1986-05-14");
		Cliente cliente9 = new Cliente(9,"43283342", "Michone", "Neuman", "3475-8075", "Asia@hotmail.com", 'F', "Rusa", "Ruiz 222", "CABA", "Buenos Aires", "1984-09-23");
		Cliente cliente10 = new Cliente(10,"44523383", "Micaela", "Lamass", "98057-2345", "Micaela@hotmail.com", 'F', "Uruguaya", "Campello 4557", "CABA", "Buenos Aires", "1982-10-25");
		
		Cuenta cuenta1 = new Cuenta(1,2,"Cuenta Sueldo", "0010001100000000000001", (float) 10000, "2021-12-01");
		Cuenta cuenta2 = new Cuenta(2,2,"Millones", "0010001100000000000002", (float) 10000, "2020-10-01");
		Cuenta cuenta3 = new Cuenta(3,1,"Ahorro", "0010001100000000000003", (float) 10000, "2020-12-15");
		Cuenta cuenta4 = new Cuenta(4,1,"Para vacaciones", "0010001100000000000004", (float) 10000, "2019-12-01");
		Cuenta cuenta5 = new Cuenta(5,2,"Ahorros", "0010001100000000000005", (float) 10000, "2020-12-12");
		Cuenta cuenta6 = new Cuenta(6,1,"Sueldo", "0010001100000000000006", (float) 10000, "2021-08-01");
		Cuenta cuenta7 = new Cuenta(7,1,"Inversiones", "0010001100000000000007", (float) 10000, "2020-10-20");
		Cuenta cuenta8 = new Cuenta(8,2,"Ganancias", "0010001100000000000008", (float) 10000, "2020-12-18");
		Cuenta cuenta9 = new Cuenta(9,1,"Ingresos", "0010001100000000000009", (float) 10000, "2020-11-01");
		Cuenta cuenta10 = new Cuenta(10,1,"De rentas", "0010001100000000000010", (float) 10000, "2021-11-11");
		Cuenta cuenta11 = new Cuenta(2,1,"Coimas", "0010001100000000000011", (float) 10000, "2021-11-12")	;
		

		Movimiento movimiento1 = new Movimiento(1,"2020-10-01", "Ahorros", (float) 24);
		Movimiento movimiento2 = new Movimiento(2,"2020-11-01", "Pago", (float) 34);
		Movimiento movimiento3 = new Movimiento(2,"2020-12-02", "Alquiler", (float) 678);
		Movimiento movimiento4 = new Movimiento(2,"2021-01-03", "Deudas", (float) 67);
		Movimiento movimiento5 = new Movimiento(2,"2021-02-04", "Prestamo", 453.6f);
		Movimiento movimiento6 = new Movimiento(3,"2021-03-05", "Seguro", 45);
		Movimiento movimiento7 = new Movimiento(4,"2021-04-06", "Drogas", 454.5f);
		Movimiento movimiento8 = new Movimiento(5,"2021-05-07", "Regalo", (float) 926);
		Movimiento movimiento9 = new Movimiento(6,"2021-06-08", "Greenpeace", (float) 89);
		Movimiento movimiento10 = new Movimiento(7,"2021-07-08", "Guinio Guinio", (float) 2678.9);


		session.beginTransaction();

	    session.save(t_cuenta_pesos);
	    session.save(t_cuenta_dolares);
	    
	    session.save(user1);
	    session.save(user2);
	    session.save(user3);
	    session.save(user4);
	    session.save(user5);
	    session.save(user6);
	    session.save(user7);
	    session.save(user8);
	    session.save(user9);
	    session.save(user10);

	    session.save(cliente1);
	    session.save(cliente2);
	    session.save(cliente3);
	    session.save(cliente4);
	    session.save(cliente5);
	    session.save(cliente6);
	    session.save(cliente7);
	    session.save(cliente8);
	    session.save(cliente9);
	    session.save(cliente10);

	    session.save(cuenta1);
	    session.save(cuenta2);
	    session.save(cuenta3);
	    session.save(cuenta4);
	    session.save(cuenta5);
	    session.save(cuenta6);
	    session.save(cuenta7);
	    session.save(cuenta8);
	    session.save(cuenta9);
	    session.save(cuenta10);
	    
	    session.save(movimiento1);
	    session.save(movimiento2);
	    session.save(movimiento3);
	    session.save(movimiento4);
	    session.save(movimiento5);
	    session.save(movimiento6);
	    session.save(movimiento7);
	    session.save(movimiento8);
	    session.save(movimiento9);
	    session.save(movimiento10);

	    session.getTransaction().commit();    
	    System.out.println("FIN de carga de datos de ejemplo.");
	}
	
	public static String traerPassword(String usuario) // Ejemplo de metodo para traer datos por HQL
	{	   
		String clave="";
	    List<String> listaDocentes= (List<String>) session.createQuery("SELECT contrasenia FROM Usuario u where nombre='"+usuario+"'").list();
	    for (String contrasenia : listaDocentes) {
			System.out.println(contrasenia);
			clave=contrasenia;
		}
		return clave; 
	}

    public static Usuario traerUsuario(int id)
	{	   
		return (Usuario)session.get(Usuario.class,id); 
	}
    
    
    public static List<Cliente> getListaClientes() // Ejemplo de metodo para traer datos por HQL
	{	   
    	
    	/*List<Object[]> listDatos = session.createQuery("SELECT id_usuario, dni, nombre, apellido, telefono, email, sexo, nacionalidad, direccion, localidad, provincia, fecha_nacimiento FROM Cliente").list();

    	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    	
    	for (Object[] datos : listDatos) {

			Cliente clientex = new Cliente((int) datos[0], (String) datos[1], (String) datos[2], (String) datos[3], (String) datos[4], (String) datos[5], (char) datos[6], (String) datos[7], (String) datos[8], (String) datos[9], (String) datos[10], (String) datos[11]);    		
    		listaClientes.add(clientex); 
    		
    		System.out.println(clientex.toString());
    	    
    	}
    	
    	return listaClientes;
    	*/
    	
    	Criteria cr = session.createCriteria(Cliente.class);
    	List<Cliente> results = cr.list();
    	

    	for(Cliente cli : results) {
    		System.out.println(cli.toString());
    		
     	}
    	
    	return results;
    	
	}

    public void UpdateGenerico(Object o) {
    	session.update(o);
    }
    
    public void eliminarCliente(Integer c) {
		 
		String hql = "UPDATE Cliente SET eliminado = true WHERE id = :id";
		Query q = session.createQuery(hql);
		q.setParameter("id", c);
		int r = q.executeUpdate();
	}
    
    public Cliente getCliente(int id)
	{	   
		return (Cliente)session.get(Cliente.class, id); 
	}
    
}
