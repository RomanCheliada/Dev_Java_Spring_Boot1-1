package ua.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.City;
import ua.service.CityService;

@Controller
@RequestMapping("/admin/city")
@SessionAttributes("city")
public class AdminCityController {
	
	private final CityService service;
	
	@Autowired
	public AdminCityController(CityService service) {
		this.service = service;
	}
	
	@ModelAttribute("city")
	public City getForm(){
		return new City();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("citys", service.findAll());
		return "city";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/city";
	}
	
	@PostMapping
	public String save(@ModelAttribute("city") @Valid City city,BindingResult br, SessionStatus status, Model model){
		if(br.hasErrors()) return show(model);
		service.save(city);
		return cancel(status);
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("city", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/city";
	}
}
