package ua.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.model.request.CargoRequest;
import ua.service.CargoService;

@Controller
@RequestMapping("/admin/cargo")
@SessionAttributes("cargo")
public class AdminCargoController {
	
private final CargoService service;

	@Autowired
	public AdminCargoController(CargoService service) {
		this.service = service;
	}
	
	@ModelAttribute("cargo")
	public CargoRequest getForm(){
		return new CargoRequest();
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cargos", service.findAllView());
		model.addAttribute("cities", service.findAllCity());
		model.addAttribute("goodss", service.findAllGoods());
		return "cargo";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/cargo";
	}
	
	
	

}
