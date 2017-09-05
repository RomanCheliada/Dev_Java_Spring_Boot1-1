package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.TransporterService;

@Controller
@RequestMapping("/admin/transporter")
public class AdminTransporterController {
	
	private final TransporterService service;

	@Autowired
	public AdminTransporterController(TransporterService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("transporters", service.findAllIndexView(pageable));
		return "transporter";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/transporter";
	}

}
