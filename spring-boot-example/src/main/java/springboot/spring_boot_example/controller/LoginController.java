// In this file login operations are performed
package springboot.spring_boot_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import springboot.spring_boot_example.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String pw) {
		boolean isValidUser = loginService.isValidUser(name, pw);
		
		if(!isValidUser) {
			model.put("errorMessage", "Invalid credentials");
			return "login";
		}
		model.put("name", name);
		model.put("pw", pw);
		return "welcome";
	}
	
	@RequestMapping("/")
	public String home() {
		return "spring boot is working";
	}
}
