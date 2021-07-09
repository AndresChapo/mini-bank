package dao;

import java.sql.Date;
import java.time.LocalDate;
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
import entidades.Transferencia;
import entidades.Usuario;

public class ConfigHibernate {

	private SessionFactory sessionFactory;
	public static Session session;   /////   HACER UN BEAN DEL SESSION
	Configuration configuration;
    ServiceRegistry serviceRegistry;
    boolean existo;
    
    
	public ConfigHibernate()
	{
		if (existo==false) {
			Configuration configuration = new Configuration();
	        configuration.configure();
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        
	        existo=true;
	        
		}else {
			System.out.println("ConfigHibernate ya existe, no se lo reinstancia.");
		}
	}
	
	public Session abrirConexion()
	{
//		if (session == null) {
			System.out.println("Conectando");
			session=sessionFactory.openSession();
			altaDatosEjemplo();
	//	}

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
		Usuario user4 = new Usuario("Bruno","adminadmin",false);
		Usuario user5 = new Usuario("Pedro","Armenia1954",true);
		Usuario user6 = new Usuario("Juan","L1br0sGr4t1s",false);
		Usuario user7 = new Usuario("Carlos86","djkd9d8dje7",false);
		Usuario user8 = new Usuario("AlbertoAlberto","hastaLaVictoria",false);
		Usuario user9 = new Usuario("Asia","AsiaMisticaMichone",false);
		Usuario user10 = new Usuario("Micaela19","pokemon",false);

		Cliente cliente1 = new Cliente("11222333", "Nicolas", "Slemenson ", "1234-3747", "Nicolas@hotmail.com", 'M', "Argentino", "Calle real 234", "CABA", "Buenos Aires", "1980-10-12", user1);
		Cliente cliente2 = new Cliente("34717846", "Andy", "Argento", "1234-1234", "Andy@hotmail.com", 'M', "Argentino", "9 de Julio falsa 23", "San Fernando", "Buenos Aires", "1988-11-12", user2);
		Cliente cliente3 = new Cliente("40223343", "Nahu", "Revollo", "6345-3478", "Nahu@hotmail.com", 'M', "Argentino", "Rivadavia 4678", "CABA", "Buenos Aires", "1986-10-15", user3);
		Cliente cliente4 = new Cliente("42233843", "Bruno", "Daglio", "8678-2345", "Bruno@hotmail.com", 'M', "Argentino", "Bravo 456", "Bolivar", "Buenos Aires", "1981-12-12", user4);
		Cliente cliente5 = new Cliente("32825303", "Pedro", "Lerose", "4586-7092", "Pedro@hotmail.com", 'M', "Peruano", "Callao 897", "CABA", "Buenos Aires", "1983-05-25", user5);
		Cliente cliente6 = new Cliente("32996348", "Juan", "Gomez", "4845-3557", "Juan@hotmail.com", 'M', "Argentino", "Corrientes 6345", "CABA", "Buenos Aires", "1985-07-11", user6);
		Cliente cliente7 = new Cliente("42263933", "Carlos", "Gonzalez", "3456-2447", "Carlos86@hotmail.com", 'M', "Chileno", "Malvinas 234", "CABA", "Buenos Aires", "19870-11-15", user7);
		Cliente cliente8 = new Cliente("20283042", "Alberto", "Rodriguez", "6897-9774", "AlbertoAlberto@hotmail.com", 'M', "Argentino", "Frias 27", "CABA", "Buenos Aires", "1986-05-14", user8);
		Cliente cliente9 = new Cliente("43283342", "Michone", "Neuman", "3475-8075", "Asia@hotmail.com", 'F', "Rusa", "Ruiz 222", "CABA", "Buenos Aires", "1984-09-23", user9);
		Cliente cliente10 = new Cliente("44523383", "Micaela", "Lamass", "98057-2345", "Micaela@hotmail.com", 'F', "Uruguaya", "Campello 4557", "CABA", "Buenos Aires", "1982-10-25", user10);		
		
		
		Date date1_cuenta = Date.valueOf(LocalDate.of (2021, 12, 01));
		Date date2_cuenta = Date.valueOf(LocalDate.of (2020, 10, 01));
		Date date3_cuenta = Date.valueOf(LocalDate.of (2020, 12, 15));
		Date date4_cuenta = Date.valueOf(LocalDate.of (2019, 12, 01));
		Date date5_cuenta = Date.valueOf(LocalDate.of (2020, 12, 12));
		Date date6_cuenta = Date.valueOf(LocalDate.of (2021, 8, 01));
		Date date7_cuenta = Date.valueOf(LocalDate.of (2020, 10, 20));
		Date date8_cuenta = Date.valueOf(LocalDate.of (2020, 12, 18));
		Date date9_cuenta = Date.valueOf(LocalDate.of (2020, 11, 01));
		Date date10_cuenta = Date.valueOf(LocalDate.of(2021, 11, 11));
		Date date11_cuenta = Date.valueOf(LocalDate.of(2021, 11, 12));
		Date date12_cuenta = Date.valueOf(LocalDate.of(2019, 12, 01));
		Date date13_cuenta = Date.valueOf(LocalDate.of(2019, 12, 01));

        Cuenta cuenta1 = new Cuenta(t_cuenta_dolares,  "Cuenta Sueldo", "0010001100000000000001", 					(float) 10000, date1_cuenta, cliente1);
		Cuenta cuenta2 = new Cuenta(t_cuenta_dolares,  "Millones", "0010001100000000000002", 						(float) 10000, date2_cuenta, cliente2);
		Cuenta cuenta3 = new Cuenta(t_cuenta_pesos,	   "Ahorro", "0010001100000000000003", 							(float) 10000, date3_cuenta, cliente3);
		Cuenta cuenta4 = new Cuenta(t_cuenta_pesos,	   "Para vacaciones MDQ", "0010001100000000000004", 			(float) 10000, date4_cuenta, cliente4);
		Cuenta cuenta5 = new Cuenta(t_cuenta_dolares,  "Ahorros", "0010001100000000000005", 						(float) 10000, date5_cuenta, cliente5);
		Cuenta cuenta6 = new Cuenta(t_cuenta_pesos,	   "Sueldo", "0010001100000000000006", 							(float) 10000, date6_cuenta, cliente6);
		Cuenta cuenta7 = new Cuenta(t_cuenta_pesos,	   "Inversiones", "0010001100000000000007", 					(float) 10000, date7_cuenta, cliente7);
		Cuenta cuenta8 = new Cuenta(t_cuenta_dolares,  "Ganancias", "0010001100000000000008", 						(float) 10000, date8_cuenta, cliente8);
		Cuenta cuenta9 = new Cuenta(t_cuenta_pesos,	   "Ingresos", "0010001100000000000009", 						(float) 10000, date9_cuenta, cliente9);
		Cuenta cuenta10 = new Cuenta(t_cuenta_pesos,   "De rentas", "0010001100000000000010", 						(float) 10000, date10_cuenta, cliente10);
		Cuenta cuenta11 = new Cuenta(t_cuenta_pesos,   "Coimas", "0010001100000000000011", 							(float) 10000, date11_cuenta, cliente2)	;
		Cuenta cuenta12 = new Cuenta(t_cuenta_pesos,   "Para vacaciones Villa Gesell", "0010001100000000000111", 	(float) 10000, date12_cuenta, cliente4);
		Cuenta cuenta13 = new Cuenta(t_cuenta_pesos,   "Para vacaciones Santa Teresita", "0010001100000000000222", 	(float) 10000, date13_cuenta, cliente4);	
		
		
		Date date1 = Date.valueOf(LocalDate.of(2020, 11, 07));
		Date date2 = Date.valueOf(LocalDate.of(2020, 11, 07));
		Date date3 = Date.valueOf(LocalDate.of(2020, 12, 05));
		Date date4 = Date.valueOf(LocalDate.of(2020, 12, 14));
		Date date5 = Date.valueOf(LocalDate.of(2020, 12, 24));
		Date date6 = Date.valueOf(LocalDate.of(2021, 05, 11));
		Date date7 = Date.valueOf(LocalDate.of(2021, 06, 02));
		Date date8 = Date.valueOf(LocalDate.of(2021, 07, 03));
		Date date9 = Date.valueOf(LocalDate.of(2021, 07, 04));
		Date date10 = Date.valueOf(LocalDate.of(2021, 07, 05));

		Movimiento movimiento1  	= new Movimiento(cuenta1, date1 , "Ahorros", 		(float) 24);
		Movimiento movimiento1_2  	= new Movimiento(cuenta2, date1 , "Ahorros", 		(float) (24 * -1));
		Movimiento movimiento2  	= new Movimiento(cuenta2, date2 , "Pago", 			(float) 34);
		Movimiento movimiento2_2  	= new Movimiento(cuenta1, date2 , "Pago", 			(float) (34 * -1));
		Movimiento movimiento3  	= new Movimiento(cuenta2, date3 , "Alquiler", 		(float) 678);
		Movimiento movimiento3_2  	= new Movimiento(cuenta1, date3 , "Alquiler", 		(float) (678 * -1));
		Movimiento movimiento4  	= new Movimiento(cuenta2, date4 , "Deudas", 		(float) 67);
		Movimiento movimiento4_2  	= new Movimiento(cuenta1, date4 , "Deudas", 		(float) (67 * -1));
		Movimiento movimiento5  	= new Movimiento(cuenta2, date5 , "Prestamo", 		453.6f);
		Movimiento movimiento5_2  	= new Movimiento(cuenta1, date5 , "Prestamo", 		(453.6f * -1));
		Movimiento movimiento6  	= new Movimiento(cuenta3, date6 , "Seguro", 		45);
		Movimiento movimiento6_2  	= new Movimiento(cuenta6, date6 , "Seguro", 		(45 * -1));
		Movimiento movimiento7  	= new Movimiento(cuenta4, date7 , "Expensas", 		454.5f);
		Movimiento movimiento7_2  	= new Movimiento(cuenta12, date7 , "Expensas",		(454.5f * -1));
		Movimiento movimiento8  	= new Movimiento(cuenta5, date8 , "Regalo", 		(float) 926);
		Movimiento movimiento8_2  	= new Movimiento(cuenta8, date8 , "Regalo", 		(float) (926 * -1));
		Movimiento movimiento9  	= new Movimiento(cuenta6, date9 , "Greenpeace", 	(float) 89);
		Movimiento movimiento9_2  	= new Movimiento(cuenta3, date9 , "Greenpeace", 	(float) (89 * -1));
		Movimiento movimiento10 	= new Movimiento(cuenta7, date10 , "Guinio Guinio", (float) 2678.9);
		Movimiento movimiento10_2 	= new Movimiento(cuenta9, date10 , "Guinio Guinio", (float) (2678.9 * -1));

		Transferencia trans1  = new Transferencia("Ahorros", 		(float) 24, 	date1,  	cuenta1, cuenta2);
		Transferencia trans2  = new Transferencia("Pago", 			(float) 34, 	date2,  	cuenta2, cuenta1);
		Transferencia trans3  = new Transferencia("Alquiler", 		(float) 678, 	date3,  	cuenta2, cuenta1);
		Transferencia trans4  = new Transferencia("Deudas", 		(float) 67, 	date4,  	cuenta2, cuenta1);
		Transferencia trans5  = new Transferencia("Prestamo", 		453.6f, 		date5,  	cuenta2, cuenta1);
		Transferencia trans6  = new Transferencia("Seguro", 		45, 			date6,  	cuenta3, cuenta6);
		Transferencia trans7  = new Transferencia("Expensas", 		454.5f, 		date7,  	cuenta4, cuenta12);
		Transferencia trans8  = new Transferencia("Regalo", 		(float) 926, 	date8,  	cuenta5, cuenta8);
		Transferencia trans9  = new Transferencia("Greenpeace", 	(float) 89, 	date9,  	cuenta6, cuenta3);
		Transferencia trans10 = new Transferencia("Guinio Guinio", 	(float) 2678.9, date10,  	cuenta7, cuenta9);
		
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
	    session.save(cuenta11);
	    session.save(cuenta12);
	    session.save(cuenta13);
	    
	    session.save(movimiento1);
		session.save(movimiento1_2);
	    session.save(movimiento2);
		session.save(movimiento2_2);
	    session.save(movimiento3);
		session.save(movimiento3_2);
	    session.save(movimiento4);
		session.save(movimiento4_2);
	    session.save(movimiento5);
		session.save(movimiento5_2);
	    session.save(movimiento6);
		session.save(movimiento6_2);
	    session.save(movimiento7);
		session.save(movimiento7_2);
	    session.save(movimiento8);
		session.save(movimiento8_2);
	    session.save(movimiento9);
		session.save(movimiento9_2);
	    session.save(movimiento10);
		session.save(movimiento10_2);
		
		session.save(trans1);
		session.save(trans2);
		session.save(trans3);
		session.save(trans4);
		session.save(trans5);
		session.save(trans6);
		session.save(trans7);
		session.save(trans8);
		session.save(trans9);
		session.save(trans10);


	    session.getTransaction().commit();    
	    System.out.println("FIN de carga de datos de ejemplo.");
	    System.out.println("---------------------------------");
	}
	    
}
