package ua.controller.user;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.model.request.OwnerRequest;
import ua.service.UserService;

@Controller
@RequestMapping("/registration")
@SessionAttributes("owner")
public class RegistrationOwnerController {
	
	private final UserService service;
	
	
	public RegistrationOwnerController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public String show(){
		return "registration";
	}
	
	@ModelAttribute("owner")
	public OwnerRequest getForm(){
		return new OwnerRequest();
	}
	
	@PostMapping
	public String save(@ModelAttribute("owner") @Valid OwnerRequest request, BindingResult br){
		if(br.hasErrors()) return show();
		service.save(request);
		return "redirect:/login";
	}
	
	

}
