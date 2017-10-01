package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.service.CargoService;

@Controller
public class CargoTransporters {
	
	private final CargoService cService;

	public CargoTransporters(CargoService cService) {
		this.cService = cService;
	}

	@GetMapping("/cargo/transporters/{id}")
	public String listTransporters(@PathVariable Integer id, Model model){
		model.addAttribute("transporters",cService.findListTransporters(id));
		return "cargoTransporters";
	}
	
	@GetMapping("/cargo/transporters/{cargoId}/{transporterId}")
	public String confirm(@PathVariable Integer cargoId,@PathVariable Integer transporterId){
		cService.confirm(cargoId,transporterId);
		return "redirect:/profile";
	}
	
	@GetMapping("/cargo/transporters/{cargoId}/{transporterId}/delete")
	public String delete (@PathVariable Integer cargoId,@PathVariable Integer transporterId){
		cService.deleteFromList(cargoId,transporterId);
		return "redirect:/cargo/transporters/{cargoId}/{transporterId}";
	}
}
