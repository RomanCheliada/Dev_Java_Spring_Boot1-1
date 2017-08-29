package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CargoRequest;
import ua.service.CargoService;

@Controller
@RequestMapping("/add-order")
@SessionAttributes("cargo")
public class UserAddOrderController {
	
	private final CargoService service;

	
	public UserAddOrderController(CargoService service) {
		this.service = service;
	}

	
	@ModelAttribute("cargo")
	public CargoRequest getForm(){
		return new CargoRequest();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cities", service.findAllCity());
		model.addAttribute("goodss", service.findAllGoods());
		return "add-order";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cargo") CargoRequest request,SessionStatus status){
		service.save(request);
		return cancel(status);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}
}
