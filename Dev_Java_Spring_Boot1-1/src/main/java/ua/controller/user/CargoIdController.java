package ua.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CargoService;

@Controller
@RequestMapping("/cargo/{id}")
public class CargoIdController {
	
	private final CargoService service;
	
	public CargoIdController(CargoService service) {
		this.service = service;
	}


	@GetMapping
	public String show(@PathVariable Integer id, Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("cargo",service.findOneView(id));
//		model.addAttribute("owner",service.findOwnerView(id));
		return "cargoID";
	}

}
