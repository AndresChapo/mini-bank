package principal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ConfigHibernate; 
import entidades.Usuario;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Tipo_cuenta;


public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");

		ConfigHibernate ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
			    
	    ch.traerPassword("Andy");
		//((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
