package eu.korneev.sergey.battleships.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import eu.korneev.sergey.battleships.models.LoginModel;
import eu.korneev.sergey.battleships.models.RegistrationModel;
import eu.korneev.sergey.battleships.services.LoginService;
import eu.korneev.sergey.battleships.services.PageUrlService;
import eu.korneev.sergey.battleships.services.RegistrationService;
import eu.korneev.sergey.battleships.services.RequestSupport;



@Controller
@SessionAttributes
@RequestMapping(value = { "/register", "/sendregister.html" })
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PageUrlService urlService;
	

	private static Logger log = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String printWelcome(Model model,HttpServletRequest request) {
		if(!RequestSupport.isUserLoggedIn(request)){
			model.addAttribute("sendregister", new RegistrationModel());
			
			model.addAttribute("page","/WEB-INF/jsp/register.jsp");
			model.addAttribute("urls",urlService.getLinksForPage("register",false));
			model.addAttribute("barpage","/WEB-INF/jsp/bar.jsp");
		}
		else{
			model.addAttribute("urls",urlService.getLinksForPage("register",true));
			model.addAttribute("page","/WEB-INF/jsp/after-registration.jsp");
			model.addAttribute("barpage","/WEB-INF/jsp/logoutbar.jsp");
		}
		return "sceleton";

	}

	@RequestMapping(value = "/sendregister.html", method = RequestMethod.POST)
	public String addContact(
			@ModelAttribute("registermodel") RegistrationModel info ,Model model,HttpServletRequest request,HttpServletResponse response) {
		if(!RequestSupport.isUserLoggedIn(request)){
			model.addAttribute("sendregister", info);
			if(!registrationService.validateRegisterInput(info)){
				model.addAttribute("message","passwords must match!");
				return printWelcome(model,request);
			}
			if(registrationService.registerNewUser(info)){
				loginService.login(info.getUserName(),request,response,info.getPassWord());
				model.addAttribute("urls",urlService.getLinksForPage("after-registration",true));
				model.addAttribute("logout", "logout");
				model.addAttribute("page","/WEB-INF/jsp/after-registration.jsp");
				return "sceleton";
			}
			model.addAttribute("message","this user already exists");
		}
		return printWelcome(model,request);
	}

}
