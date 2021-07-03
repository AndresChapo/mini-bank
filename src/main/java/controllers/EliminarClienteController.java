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
import entidades.Usuario;
import service.ClienteService;
import serviceInterfaz.ClienteServiceInterfaz;

@Controller
public class EliminarClienteController {
	
	ModelAndView mv;
	ConfigHibernate ch;
	private ClienteService clienteService;
	
	public EliminarClienteController(){
		mv = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		ch = (ConfigHibernate)appContext.getBean("conexionHibernate"); 
		clienteService = new ClienteService();
	}
	 
	 
	@RequestMapping("eliminarCliente.html")
	public ModelAndView eliminarCliente(Integer id) { 
		
		Cliente c = new Cliente();
		c.setId(id);
		 
		clienteService.eliminarCliente(c);
		 
		return mv;
	}

}
