package principal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate; 
import entidades.Usuario;
import service.ClienteService;
import service.CuentaService;
import service.MovimientoService;
import service.UsuarioService;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Tipo_cuenta;


public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext;
//		ModelAndView mv;
	//	ConfigHibernate ch;
		ClienteService clienteService;
		MovimientoService movimientoService;
		UsuarioService usuarioService;
		CuentaService cuentaService;
		
		//	mv = new ModelAndView();
			appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
			//ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
			clienteService = (ClienteService)appContext.getBean("clienteService");
			movimientoService = (MovimientoService)appContext.getBean("movimientoService");
			usuarioService = (UsuarioService)appContext.getBean("usuarioService");
			cuentaService = (CuentaService)appContext.getBean("cuentaService");	

		
		movimientoService.generarMovimientos("1234", "0010001100000000000004", "11", "Deposito de prueba");
	}
	
}
