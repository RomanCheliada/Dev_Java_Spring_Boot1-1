package ua.controller.user;

import java.security.Principal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.model.filter.SimpleFilter;
import ua.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class UserCargosController {
	
	private final CargoService service;
	
	public UserCargosController(CargoService service) {
		this.service = service;
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model,Principal principal, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("cargos", service.findAllView(pageable, filter));
		return "allCargos";
	}
	
	

}
