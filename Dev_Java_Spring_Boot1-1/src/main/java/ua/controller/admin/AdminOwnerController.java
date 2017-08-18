package ua.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.OwnerService;

@Controller
@RequestMapping("/admin/owner")
public class AdminOwnerController {
	
	private final OwnerService service;

	public AdminOwnerController(OwnerService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("owners", service.findAll());
		return "owner";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/owner";
	}
	

}
