package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ConfigHibernate;

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
		
		String claveEnBD = ch.traerPassword(txtBoxUsuario);
		System.out.println(claveEnBD);
		
		if(claveEnBD.equals(txtBoxClave)) {
			System.out.println("Coincide la clave!");
		}else {
			System.out.println("Clave incorrecta!");
		}
		
		mv.setViewName("index");
		mv.addObject("usuarioValido", "true");
		return mv;
	}

}
