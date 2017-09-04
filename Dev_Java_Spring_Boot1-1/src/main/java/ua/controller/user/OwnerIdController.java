package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.OwnerService;

@Controller
@RequestMapping("/owner/{id}")
public class OwnerIdController {
	
	private final OwnerService service;
	
	
	public OwnerIdController(OwnerService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(@PathVariable Integer id, Model model){
		model.addAttribute("owner", service.findOneView(id));
		return "ownerID";
	}
	

}