package ua.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CargoService;
import ua.service.TransporterService;

@Controller
@RequestMapping("/cargo/{id}")
public class CargoIdController {
	
	private final CargoService service;
	
	private final TransporterService tService;
	
	public CargoIdController(CargoService service, TransporterService tService) {
		this.service = service;
		this.tService = tService;
	}

	@GetMapping
	public String show(@PathVariable Integer id, Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("cargo",service.findOneView(id));
		model.addAttribute("owner",service.findOwnerView(id));
		return "cargoID";
	}
	
	@GetMapping("/takeJob")
	public String takeJob(@PathVariable Integer id, Principal principal,Model model){
		tService.takeJob(id,principal.getName());
		model.addAttribute("addTakeJob", "You have been added to the list!");
		return show(id, model, principal);
	}

}