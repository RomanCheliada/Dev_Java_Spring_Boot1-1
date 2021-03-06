package ua.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.TransporterService;

@Controller
@RequestMapping("/transporter/{id}")
public class TransporterIdController {
	
	private final TransporterService service;

	public TransporterIdController(TransporterService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(@PathVariable Integer id,Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("transporter", service.findOneView(id));
		return "transporterID";
	}

}
