package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	@RequestMapping("redirectLogin.html")
	public ModelAndView eventoRedirectLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("index.html")
	public ModelAndView eventoRedirectLista() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
