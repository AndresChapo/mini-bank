package principal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.ConfigHibernate;
import dao.daoHibernate;
import entidades.Usuario;

public class Main {

	public static void main(String[] args) {

		
		//Agrego el primer usuario
		Usuario usuario1 = new Usuario();
	    usuario1.setNombre("Pepe");
	    usuario1.setContrasenia("123");
	    
	    System.out.println("Paso 1");
	    
		Usuario usuario2 = new Usuario();
	    usuario2.setNombre("Jose");
	    usuario2.setContrasenia("456");
	
		Usuario usuario3 = new Usuario();
	    usuario3.setNombre("Jose");
	    usuario3.setContrasenia("456");
	
	    
		daoHibernate.Add(usuario1);
		System.out.println("FIN");
		/**
		daoHibernate.Add(usuario2);
		daoHibernate.Add(usuario3);
		
		//Leo el usuario con ID=1
		Usuario usuario4 = daoHibernate.ReadOne(1);
		System.out.println("Info del usuario con Id 1="+usuario4.toString());
		
		//Modifico el usuario con ID=2
		
		Usuario usuario5 = new Usuario();
		usuario5.setId(2);
		usuario5.setNombre("Juan");
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
