package ua.controller.user;

import java.security.Principal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.model.filter.TransporterFilter;
import ua.service.TransporterService;

@Controller
@RequestMapping("/transporters")
public class UserTransportersController {
	
	private final TransporterService service;
	
	public UserTransportersController(TransporterService service) {
		this.service = service;
	}

	@ModelAttribute("transporterFilter")
	 	public TransporterFilter getFilter() {
	 		return new TransporterFilter();
	 	}
	
	@GetMapping
	public String show(Model model, Principal principal, @ModelAttribute("transporterFilter") TransporterFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("brands", service.findAllBrands());
		model.addAttribute("models", service.findAllModels());
		model.addAttribute("citys", service.findAllCitys());
		model.addAttribute("transporters", service.findAll(filter, pageable));
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		return "allTransporters";
	}
	
	
	@GetMapping("/clean")
	public String clean(){
		return "redirect:/transporters";
		
	}
	
}
