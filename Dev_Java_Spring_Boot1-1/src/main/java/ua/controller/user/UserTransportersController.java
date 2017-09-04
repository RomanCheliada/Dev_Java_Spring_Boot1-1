package ua.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.TransporterService;

@Controller
@RequestMapping("/transporters")
public class UserTransportersController {
	
	private final TransporterService service;
	
	public UserTransportersController(TransporterService service) {
		this.service = service;
	}


	@GetMapping
	public String show(Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("transporters", service.findAllIndexView());
		return "allTransporters";
	}

}
