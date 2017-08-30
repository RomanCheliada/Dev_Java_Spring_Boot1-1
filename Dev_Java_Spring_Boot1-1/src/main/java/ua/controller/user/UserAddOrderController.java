package ua.controller.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CargoRequest;
import ua.service.AddOrderService;
@Controller
@RequestMapping("/add-order")
@SessionAttributes("cargo")
public class UserAddOrderController {
	
	private final AddOrderService addOrderService;

	
	public UserAddOrderController(AddOrderService addOrderService) {
		this.addOrderService = addOrderService;
	}

	@ModelAttribute("cargo")
	public CargoRequest getForm(){
		return new CargoRequest();
	}
	
	@GetMapping
	public String show(Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("cities", addOrderService.findAllCity());
		model.addAttribute("goodss", addOrderService.findAllGoods());
		return "add-order";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cargo") CargoRequest request,SessionStatus status, Principal principal){
		addOrderService.save(request, principal);
		return cancel(status);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}
}
