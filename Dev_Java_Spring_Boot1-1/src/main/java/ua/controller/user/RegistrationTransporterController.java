package ua.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.entity.Transporter;
import ua.service.TransporterService;

@Controller
@RequestMapping("/registration-transporter")
@SessionAttributes("transporter")
public class RegistrationTransporterController {
	
	private final TransporterService service;
	
	@Autowired
	public RegistrationTransporterController(TransporterService service) {
		this.service = service;
	}

	@GetMapping
	public String show(Model model){
		model.addAttribute("brands", service.findAllBrands());
		model.addAttribute("models", service.findAllModels());
		return "registration-transporter";
	}
	
	@ModelAttribute("transporter")
	public Transporter getForm(){
		return new Transporter();
	}

}
