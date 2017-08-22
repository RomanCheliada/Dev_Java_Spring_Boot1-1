package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.entity.Owner;

@Controller
@RequestMapping("/registration")
@SessionAttributes("owner")
public class RegistrationOwnerController {
	
	@GetMapping
	public String show(){
		return "registration";
	}
	
	@ModelAttribute("owner")
	public Owner getForm(){
		return new Owner();
	}

}
