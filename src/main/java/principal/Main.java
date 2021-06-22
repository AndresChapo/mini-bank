package principal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.ConfigHibernate;
import dao.daoHibernate;
import entidades.Usuario;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Tipo_cuenta;

public class Main {

	public static void main(String[] args) {
		
		Usuario user1 = new Usuario("Pepe","1234asdf",true);
		Usuario user2 = new Usuario("Pepe","1234asdf",true);
		Usuario user3 = new Usuario("Pepe","1234asdf",true);
		Usuario user4 = new Usuario("Pepe","1234asdf",true);
		Usuario user5 = new Usuario("Pepe","1234asdf",true);
		Usuario user6 = new Usuario("Pepe","1234asdf",true);
		Usuario user7 = new Usuario("Pepe","1234asdf",true);
		Usuario user8 = new Usuario("Pepe","1234asdf",true);
		Usuario user9 = new Usuario("Pepe","1234asdf",true);
		Usuario user10 = new Usuario("Pepe","1234asdf",true);
		
		Cuenta cuenta1 = new Cuenta(1,1,"Cuenta Sueldo", "123123123123123123", (float) 12.4, "2020-12-01");
		Cliente cliente1 = new Cliente(1,"11222333", "Pepe", "Argento", "1234-1234", "pepeargento@hotmail.com", 'M', "Argentino", "Calle falsa 123", "San Fernando", "Buenos Aires", "1988-10-12");
		Movimiento movimiento1 = new Movimiento(123,"2020-12-01", "Ahorros", (float) 24);
		Tipo_cuenta t_cuenta_pesos = new Tipo_cuenta("Caja de ahorro en pesos");
		Tipo_cuenta t_cuenta_dolares = new Tipo_cuenta("Caja de ahorro en dólares");
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	    session.beginTransaction();
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
	    session.save(cuenta1);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
		
		System.out.println("FIN");
		/**
		daoHibernate.Add(t_cuenta_pesos);
		daoHibernate.Add(t_cuenta_dolares);

				
		//Leo el usuario con ID=1
		Usuario usuario4 = daoHibernate.ReadOne(1);
		System.out.println("Info del usuario con Id 1="+usuario4.toString());
		
		//Modifico el usuario con ID=2
		
		Usuario usuario5 = new Usuario();
		usuario5.setId(2);
		usuario5.setNombre("Don Juan");
		usuario5.setContrasenia("456");
		daoHibernate.Update(usuario5);

		//Leo el usuario con ID=1
		Usuario usuario6 = daoHibernate.ReadOne(2);
		System.out.println("Info del usuario con Id 2="+usuario6.toString());
				
		//Elimino el usuario 3
		daoHibernate.Delete(usuario3);
		
		**/
	}
	
	
	
}
