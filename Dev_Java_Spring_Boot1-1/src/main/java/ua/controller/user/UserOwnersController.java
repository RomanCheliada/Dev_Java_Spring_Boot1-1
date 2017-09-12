package ua.controller.user;

import java.security.Principal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class UserOwnersController {
	
	private final OwnerService service;

	public UserOwnersController(OwnerService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model, Principal principal, @PageableDefault Pageable pageable){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("owners", service.findAllView(pageable));
		return "allOwners";
	}

}
