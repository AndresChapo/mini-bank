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
import entidades.Cuenta;
import entidades.Usuario;
import service.ClienteService;
import service.CuentaService;

@Controller
public class LoginController {
	ModelAndView mv;
	ConfigHibernate ch;
	
	public LoginController(){
		mv = new ModelAndView();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		ch = (ConfigHibernate)appContext.getBean("conexionHibernate");
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
		
		Usuario usuario = ch.getUsuarioByNombreUsuario(txtBoxUsuario);
		// System.out.println(claveEnBD);
		
		if(txtBoxClave.equals(usuario.getContrasenia())) {
			mv.addObject("usuarioValido", "true");
			 
			//si es admin va a la lista de clientes 
			if(usuario.isEs_admin()) {
				List<Cliente> listaClientes = ch.getListaClientes();
				mv.addObject("listaClientes", listaClientes);
				mv.setViewName("clientesLista");
			// si no es admin va a la lista de cuentas
			} else {
				
				
				 List<Cuenta> listaCuentas= ch.getListaCuentasByUsuario(usuario.getId());
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

}
