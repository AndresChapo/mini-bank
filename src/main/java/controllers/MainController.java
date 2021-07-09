package controllers;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
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
import dao.Tipo_cuentaDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Transferencia;
import entidades.Usuario;
import service.ClienteService;
import service.CuentaService;
import service.MovimientoService;
import service.TransferenciaService;
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
	TransferenciaService transferenciaService;

	public MainController() {
		mv = new ModelAndView();
		appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		// ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
		clienteService = (ClienteService) appContext.getBean("clienteService");
		movimientoService = (MovimientoService) appContext.getBean("movimientoService");
		usuarioService = (UsuarioService) appContext.getBean("usuarioService");
		cuentaService = (CuentaService) appContext.getBean("cuentaService");
		transferenciaService = (TransferenciaService)appContext.getBean("transferenciaService");

	}

	public Object getAppContext(String nombreBean) {
		return (Object) appContext.getBean(nombreBean);
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

	/**
	 * @RequestMapping(value ="/eliminarUsuario.html" , method= { RequestMethod.GET,
	 *                       RequestMethod.POST}) public ModelAndView
	 *                       eliminarUsuario(Integer id, String nombreU, String
	 *                       passU){ ModelAndView MV = new ModelAndView();
	 *                       service.eliminarUsuario(id);
	 *                       MV.addObject("listaUsuarios",this.service.obtenerUsuarios());
	 *                       MV.setViewName("Usuarios"); MV.addObject("Mensaje",
	 *                       "Usuario eliminado"); return MV; }
	 **/

	@RequestMapping("validarUsuario.html")
	public ModelAndView validarUsuario(String txtBoxUsuario, String txtBoxClave) {
		System.out.println("Corriendo validarUsuario");
		System.out.println(txtBoxUsuario);
		System.out.println(txtBoxClave);

		Usuario usuario = (Usuario) usuarioService.getUsuarioByNombreUsuario(txtBoxUsuario);

		if (txtBoxClave.equals(usuario.getContrasenia())) {
			mv.addObject("usuarioValido", "true");

			usuarioService.setUsuarioLogueado(usuario);

			// si es admin va a la lista de clientes
			if (usuario.isEs_admin()) {
				List<Cliente> listaClientes = clienteService.getListaClientes();
				mv.addObject("listaClientes", listaClientes);
				mv.setViewName("clientesLista");
				// si no es admin va a la lista de cuentas
			} else {

				List<Cuenta> listaCuentas = cuentaService.getListaCuentasByUsuario(usuario);
				mv.addObject("listaCuentas", listaCuentas);
				mv.setViewName("cuentasLista");

			}

		} else {
			mv.addObject("usuarioValido", "false");
			System.out.println("Clave incorrecta!");
			mv.setViewName("login");
		}

		return mv;
	}

	@RequestMapping(value = "eliminarCliente.html", method = RequestMethod.GET)
	public ModelAndView eliminarCliente(@RequestParam String id) {

		Cliente c = new Cliente();
		c.setId(Integer.parseInt(id));

		clienteService.eliminarCliente(c);

		mv.setViewName("clienteEliminadoCorrectamente");
		return mv;
	}

	@RequestMapping(value = "modificacionCliente.html", method = RequestMethod.GET)
	public ModelAndView eventoModificacionCliente(@RequestParam String id) {

		if (id != null) {
			Cliente c = clienteService.getCliente(Integer.parseInt(id));
			mv.addObject("cliente", c);
		} else {
			System.out.println("el id viene null");
		}
		
		mv.setViewName("clientesModificar");

		return mv;
	}

	@RequestMapping(value = "modificarCliente.html", method = RequestMethod.POST)
	public ModelAndView modificarCliente(@RequestParam(required = false) String TXTid, String TXTnombre,
		String TXTapellido, String TXTdni, String TXTfecha, char TXTsexo, String TXTprovincia, String TXTlocalidad,
		String TXTdomicilio, String TXTtelefono, String TXTcorreo) {

		Cliente c = clienteService.parametrizarCliente(TXTid, TXTnombre, TXTapellido, TXTdni, TXTfecha, TXTsexo,
				TXTprovincia, TXTlocalidad, TXTdomicilio, TXTtelefono, TXTcorreo);

		clienteService.modificarCliente(c);

		mv.setViewName("clienteModificadoCorrectamente");
		return mv;
	}

	@RequestMapping(value="irATransferencia.html", method=RequestMethod.GET)
	public ModelAndView irATransferencia(int num_cuenta) {
		
		Usuario _usr = usuarioService.getUsuarioLogueado();
		Cuenta _cuenta = cuentaService.getCuenta(num_cuenta);
		
		if(_cuenta != null) {
			
			Cliente cliente = _cuenta.getCliente();
			Tipo_cuenta tipo_cuenta = _cuenta.getTipo_cuenta();
			
			List<Cuenta> listaDeCuentasPropias = cuentaService.getListaCuentasByTipoCuentaAndCliente(tipo_cuenta , cliente , _cuenta.getNum_cuenta());
			boolean esUnaCuentaDelUsuario = cuentaService.checkCuentaByUsuario(_usr, num_cuenta);
			  System.out.println("esUnaCuentaDelUsuario" + esUnaCuentaDelUsuario);
			if(esUnaCuentaDelUsuario == true) {
				mv.addObject("listaDeCuentasPropias", listaDeCuentasPropias);
				mv.addObject("CuentaActual", _cuenta);
				mv.setViewName("transferencia");
			} else {
				mv.addObject("Error", true);
			}
			
		} else {
			mv.addObject("Error", true);
		}

		

		return mv;
	}


	@RequestMapping(value="realizarTransferencia.html", method=RequestMethod.POST)
	public ModelAndView realizarTransferencia(String esPropia,int cuenta, String TXTcbu, String TXTsaldo, String TXTadepositar, String TXTdetalle, int cuentaOrigen) {
		
		mv.setViewName("cuentasLista"); 
		
		
		if(esPropia == null) {
			movimientoService.generarMovimientos(TXTadepositar, TXTcbu, cuentaOrigen, TXTdetalle);
		} else {
			movimientoService.generarMovimientoEnPropiaCuenta(TXTadepositar, cuentaOrigen, cuenta, TXTdetalle);			
		}
		 
		return mv;
	}
	
	@RequestMapping(value="irAMovimientos.html", method=RequestMethod.GET)
	public ModelAndView irAMovimientos(int num_cuenta) {
		
		Usuario _usr = usuarioService.getUsuarioLogueado();
		Cuenta _cuenta = cuentaService.getCuenta(num_cuenta);
		
		if(_cuenta != null) {
			
			List<Transferencia> listaDeTransferencias = transferenciaService.getListaDeTransferenciasByCuenta(_cuenta);
			boolean esUnaCuentaDelUsuario = cuentaService.checkCuentaByUsuario(_usr, num_cuenta);
			
			for (Transferencia transferencia : listaDeTransferencias ) {
				if(transferencia.getCuenta_origen().getNum_cuenta() == _cuenta.getNum_cuenta()) {
					System.out.println("Enviado");
				}
			}

			
			if(esUnaCuentaDelUsuario == true) {
				mv.addObject("listaDeTransferencias", listaDeTransferencias);
				mv.addObject("CuentaActual", _cuenta);
			} else {
				mv.addObject("Error", true);
			}
		}
		
		mv.setViewName("movimientosLista"); 
		
		
		 
		return mv;
	}

	@RequestMapping(value = "listadoClientes.html", method = RequestMethod.GET)
	public ModelAndView eventolistadoClientes() {

		mv.setViewName("clientesLista");
		List<Cliente> listaClientes = clienteService.getListaClientes();
		mv.addObject("listaClientes", listaClientes);

		return mv;
	}
	
	
	@RequestMapping(value = "verCliente.html", method = RequestMethod.GET)
	public ModelAndView eventoVerCliente(@RequestParam String id) {

		mv.setViewName("clientesVer");

		if (id != null) {
			Cliente c = clienteService.getCliente(Integer.parseInt(id));
			mv.addObject("cliente", c);
		}  

		return mv;
	}

	//MODIFICADO POR NAHUEL REVOLLO INICIO
	
	
		//PARA IR A NUEVO USUARIO
		
		
		@RequestMapping(value="NuevoClienteUsuario.html", method=RequestMethod.GET)
		public ModelAndView pantallaNuevoClienteUsuario() { 
			
			mv.setViewName("clientesNuevoSesion"); 
			
					 
			return mv;
		}
		
		//PARA GUARDAR NUEVO USUARIO
		
		@RequestMapping(value="AltaUsuario.html", method=RequestMethod.POST)
		public ModelAndView NuevoClienteUsuario(String TXTusuario,String TXTpass,String TXTrepetirpass) 
		{ 
			System.out.println(TXTusuario+", "+TXTpass+", "+TXTrepetirpass);
			
			if(TXTpass.equals(TXTrepetirpass) )
			{
				
				Usuario usuarioNuevo = new Usuario();
				
				usuarioNuevo.setContrasenia(TXTrepetirpass);
				usuarioNuevo.setNombre(TXTusuario);
				usuarioNuevo.setEliminado(false);
				usuarioNuevo.setEs_admin(false);
				
				System.out.println(usuarioNuevo.getNombre());
				
				
				
				Boolean guardo = usuarioService.GuardarUsuario(usuarioNuevo);
				
				if(guardo)
				{
					System.out.println("aca llega bien");
					
					Usuario usuario = (Usuario) usuarioService.getUsuarioByNombreUsuario(TXTusuario);
					
					mv.addObject("NuevoUsuario", usuario);
					
					mv.setViewName("clientesNuevoDatosPersonales"); 
					
				}
				
			}
			else 
			{
				System.out.println("aca llega directo al else");
				mv.setViewName("clientesNuevoSesion"); 
				
			}
			
			return mv;
		}
		
		
		
		
		
		//PARA GUARDAR NUEVO CLIENTE
		
		@RequestMapping(value="ClientesDatosPersonales.html", method=RequestMethod.POST)
		public ModelAndView altaCliente(@RequestParam(required=false) 
				String TXTnombre, String TXTapellido, String TXTdni,String TXTnacionalidad,
				String TXTfecha, char TXTsexo, String TXTprovincia, String TXTlocalidad,
				String TXTdomicilio, String TXTtelefono, String TXTcorreo,String TXTidUsuario)
		
		{ 
			Cliente nuevoCliente = new Cliente();
			
			
			nuevoCliente.setId(Integer. parseInt (  TXTidUsuario)); 
			nuevoCliente.setNombre(TXTnombre);		
			nuevoCliente.setApellido(TXTapellido);
			nuevoCliente.setDni(TXTdni);
			nuevoCliente.setNacionalidad(TXTnacionalidad);
			nuevoCliente.setFecha_nacimiento(TXTfecha);
			nuevoCliente.setSexo(TXTsexo);
			nuevoCliente.setProvincia(TXTprovincia);
			nuevoCliente.setLocalidad(TXTlocalidad);
			nuevoCliente.setDireccion(TXTdomicilio);
			nuevoCliente.setTelefono(TXTtelefono);
			nuevoCliente.setEmail(TXTcorreo);
			nuevoCliente.setEliminado(false);
			
			if(clienteService.GuardarCliente(nuevoCliente))
			{
				
				mv.setViewName("clienteNuevoCorrectamente"); 
				
				
			}	
			return mv;
			
			 
		}
		
		
		//PARA IR A NUEVA CUENTA
		
			
		
		@RequestMapping(value = "NuevoCuenta.html", method = RequestMethod.GET)
		public ModelAndView pantallaNuevoCuenta(@RequestParam String id) {

			Cliente cliente_cuenta = new Cliente();
			cliente_cuenta = clienteService.getCliente(Integer.parseInt(id));
			mv.addObject("cliente_cuenta", cliente_cuenta);
		

			mv.setViewName("cuentasnueva");
			return mv;
		}
		
		
		//PARA ASIGNAR UNA NUEVA CUENTA A UN CLIENTE
		
	
		
		
		@RequestMapping(value = "AltaCuenta.html", method = RequestMethod.POST)
		public ModelAndView altaCuenta(@RequestParam(required = false) 
		String TXTid, String TXTnombre,
	    String TXTdni, String CuentasTipo) {

			Cuenta cuentaNueva = new Cuenta();
			Cliente _cliente = clienteService.getCliente(Integer.parseInt(TXTid));
			Tipo_cuentaDao tipoCuentaDao = new Tipo_cuentaDao();
			Tipo_cuenta tipoCuenta = tipoCuentaDao.getTipoCuenta(Integer.parseInt(CuentasTipo));
			Date hoy = Date.valueOf(LocalDate.now());

			cuentaNueva.setNombre(TXTnombre);
			cuentaNueva.setCliente(_cliente);
			cuentaNueva.setFecha_creacion(hoy);
			cuentaNueva.setTipo_cuenta(tipoCuenta);;
			cuentaNueva.setEliminado(false);
			// POR DEFAULT TODAS EMPIEZAN CON ESE MONTO
			cuentaNueva.setSaldo(10000); 
			
			//CREO VARIABLE INT PARA INCREMENTAR EL CBU
			
			//Integer cbu_incrementa = (Integer.parseInt(cuentaService.ObtenerUltimoCBU()));
			
			BigInteger One = new BigInteger("1");
			BigInteger cbu_incrementa=new BigInteger(cuentaService.ObtenerUltimoCBU());
			cbu_incrementa.add(One);
			cuentaNueva.setCbu(cbu_incrementa.toString());	
			
			if(cuentaService.GuardarCuenta(cuentaNueva)){				
				mv.setViewName("cuentaNuevaCorrentamente");
			}
			

			return mv;
		}
		
		
		//MODIFICADO POR NAHUEL REVOLLO FIN

	
	
}
