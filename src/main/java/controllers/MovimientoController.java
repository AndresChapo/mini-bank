package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate;
import entidades.Cliente;
import entidades.Movimiento;
import service.MovimientoService;
import serviceInterfaz.ClienteServiceInterfaz;
import serviceInterfaz.MovimientoServiceInterfaz;

@Controller
public class MovimientoController {

	ModelAndView mv;
	ConfigHibernate ch;
	private MovimientoService movimientoService;
	
	@RequestMapping(value="realizarTransferencia.html", method=RequestMethod.POST)
	public ModelAndView realizarTransferencia(String TXTadepositar, String TXTcbu, String TXTCuentaOrigenID) {
		
		mv.setViewName("cuentasLista"); 
		
		//Movimiento m = new Movimiento();
		
		movimientoService.generarMovimientos(TXTadepositar, TXTcbu, TXTCuentaOrigenID);
		
		//movimientoService.realizarTransferencia();
		 
		return mv;
	}



}
