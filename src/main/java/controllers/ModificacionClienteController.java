package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate;
import entidades.Cliente;
import service.ClienteService;
import serviceInterfaz.ClienteServiceInterfaz;

@Controller
public class ModificacionClienteController {
	
	ModelAndView mv;
	ConfigHibernate ch;
	private ClienteService clienteService;
	
	public ModificacionClienteController(){
		mv = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
	}
	
	@RequestMapping(value="modificacionCliente.html", method=RequestMethod.GET)
	public ModelAndView eventoModificacionCliente(@RequestParam String id) { 
		
		mv.setViewName("clientesModificar"); 
		
		Cliente c = clienteService.getCliente(Integer.parseInt(id));
		mv.addObject(c);
		
		return mv;
	}
	
	
	@RequestMapping(value="modificarCliente.html", method=RequestMethod.POST)
	public ModelAndView modificarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		System.out.println("Modificando cliente" + cliente.getNombre()); 
		
		Cliente c = new Cliente();
		 
		clienteService.modificarCliente(c);
		 
		return mv;
	}
	  
	/*@RequestMapping("modificarCliente.html")
	public ModelAndView modificarCliente(String TXTnombre, String TXTapellido, String TXTdni,
			String TXTpass, String TXTfecha, char TXTsexo, String TXTprovincia, String TXTlocalidad,
			String TXTdomicilio, String TXTtelefono, String TXTcorreo) {
		System.out.println("Modificando cliente" + TXTnombre); 
		
		Cliente c = new Cliente();
		 
		clienteService.modificarCliente(c);
		 
		return mv;
	}*/

}
