package ua.controller.user;

import java.security.Principal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public String clean(@PageableDefault Pageable pageable,@ModelAttribute("transporterFilter") TransporterFilter filter){
		return "redirect:/transporters"+buildParams(pageable,filter);
		
	}
	
	
	private String buildParams(Pageable pageable, TransporterFilter filter) {
 		StringBuilder buffer = new StringBuilder();
 		buffer.append("?page=");
 		buffer.append(String.valueOf(pageable.getPageNumber()+1));
 		buffer.append("&size=");
 		buffer.append(String.valueOf(pageable.getPageSize()));
 		if(pageable.getSort()!=null){
 			buffer.append("&sort=");
 			Sort sort = pageable.getSort();
 			sort.forEach((order)->{
 				buffer.append(order.getProperty());
 				if(order.getDirection()!=Direction.ASC)
 				buffer.append(",desc");
 			});
 		}
 		return buffer.toString();
  	}
}
