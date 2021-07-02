package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate;
import entidades.Cliente;
import serviceInterfaz.ClienteServiceInterfaz;

@Controller
public class ModificacionClienteController {
	
	ModelAndView mv;
	ConfigHibernate ch;
	private ClienteServiceInterfaz clienteService;
	
	public ModificacionClienteController(){
		mv = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
	}
	
	@RequestMapping("modificacionCliente.html")
	public ModelAndView eventoModificacionCliente() {
		mv.setViewName("clientesModificar");
		return mv;
	}
	
	  
	@RequestMapping("modificarCliente.html")
	public ModelAndView modificarCliente(String TXTnombre, String TXTapellido, String TXTdni,
			String TXTpass, String TXTfecha, char TXTsexo, String TXTprovincia, String TXTlocalidad,
			String TXTdomicilio, String TXTtelefono, String TXTcorreo) {
		System.out.println("Modificando cliente" + TXTnombre); 
		
		Cliente c = new Cliente();
		 
		clienteService.modificarCliente(c);
		 
		return mv;
	}

}
