package controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Usuario;
import service.ClienteService;
import service.CuentaService;
import service.MovimientoService;
import service.UsuarioService;

@Controller
public class MainController {
	ApplicationContext appContext;
	ModelAndView mv;
	ConfigHibernate ch;
	ClienteService clienteService;
	MovimientoService movimientoService;
	UsuarioService usuarioService;
	CuentaService cuentaService;
	
	public MainController(){ 
		mv = new ModelAndView();
		appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		//ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
		clienteService = (ClienteService)appContext.getBean("clienteService");
		movimientoService = (MovimientoService)appContext.getBean("movimientoService");
		usuarioService = (UsuarioService)appContext.getBean("usuarioService");
		cuentaService = (CuentaService)appContext.getBean("cuentaService");
	}

	public Object getAppContext(String nombreBean) {
		return (Object)appContext.getBean(nombreBean);
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}

	public ModelAndView getMv() {
		return mv;
	}

	public void setMv(ModelAndView mv) {
		this.mv = mv;
	}

	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}
	
		
	@RequestMapping("redirectLogin.html")
	public ModelAndView eventoRedirectLogin() {
		mv.setViewName("login");
		return mv;
	}
	
	
	// fdas
	
	/**
	@RequestMapping(value ="/eliminarUsuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eliminarUsuario(Integer id, String nombreU, String passU){
		ModelAndView MV = new ModelAndView();
		service.eliminarUsuario(id);
		MV.addObject("listaUsuarios",this.service.obtenerUsuarios());
		MV.setViewName("Usuarios"); 
		MV.addObject("Mensaje", "Usuario eliminado");
		return MV;
	}
	**/
	
	@RequestMapping("validarUsuario.html")
	public ModelAndView validarUsuario(String txtBoxUsuario, String txtBoxClave) {
		System.out.println("Corriendo validarUsuario");
		System.out.println(txtBoxUsuario);
		System.out.println(txtBoxClave);
		
		//Usuario usuario = ch.getUsuarioByNombreUsuario(txtBoxUsuario);
		Usuario usuario = (Usuario) usuarioService.getUsuarioByNombreUsuario(txtBoxUsuario);
		// System.out.println(claveEnBD);
		
		if(txtBoxClave.equals(usuario.getContrasenia())) {
			mv.addObject("usuarioValido", "true");
			 
			//si es admin va a la lista de clientes 
			if(usuario.isEs_admin()) {
				List<Cliente> listaClientes = clienteService.getListaClientes();
				mv.addObject("listaClientes", listaClientes);
				mv.setViewName("clientesLista");
			// si no es admin va a la lista de cuentas
			} else {
				
				
				List<Cuenta> listaCuentas= cuentaService.getListaCuentasByUsuario(usuario.getId());
				mv.addObject("listaCuentas", listaCuentas);
				mv.setViewName("cuentasLista");
				 

				/* POR FAVOR NO BORRAR ESTO ES PARA CUANDO EN LA LISTA DE CLIENTES CLICKEE EN EL BOTON DE TRANSFERIR
				 * SALUDOS: Bruno Jajajaj
				Cuenta _cuenta = ch.getCuenta(4);
				List<Cuenta> listaDeCuentasPropias = ch.getListaCuentasByTipoCuentaAndClienteId(_cuenta.getTipo_cuenta(), _cuenta.getId_cliente(), _cuenta.getNum_cuenta());
				mv.addObject("listaDeCuentasPropias", listaDeCuentasPropias);
				mv.addObject("Cuenta", _cuenta);
				mv.setViewName("transferencia"); 
				 */
				
			}
			
		}else {
			mv.addObject("usuarioValido", "false");
			System.out.println("Clave incorrecta!");
			mv.setViewName("login");
		}
		
		
		// mv.addObject("usuarioValido", "true");
		return mv;
	}
	
	@RequestMapping("eliminarCliente.html")
	public ModelAndView eliminarCliente(Integer id) { 
		
		Cliente c = new Cliente();
		c.setId(id);
		 
		clienteService.eliminarCliente(c);
		 
		return mv;
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

	@RequestMapping(value="realizarTransferencia.html", method=RequestMethod.POST)
	public ModelAndView realizarTransferencia(String TXTadepositar, String TXTcbu, String TXTCuentaOrigenID, String detalle) {
		
		mv.setViewName("cuentasLista"); 
		 
		//Movimiento m = new Movimiento();
		
		movimientoService.generarMovimientos(TXTadepositar, TXTcbu, TXTCuentaOrigenID, detalle);
		
		//movimientoService.realizarTransferencia();
		 
		return mv;
	}
}
