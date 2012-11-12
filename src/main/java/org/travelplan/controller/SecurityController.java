package org.travelplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
	
/*	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView printWelcome() {
		ModelAndView model = new ModelAndView("loginPage");
		model.addObject("message", "Spring Security Hello World 10");
		model.addObject("mes", "Spring");
		return model;
	}*/
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView printWelcome() {
		ModelAndView model = new ModelAndView("profile");
		return model;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) { 
		return "login";
	}
		
	@RequestMapping(value="/loginFailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}	
}
