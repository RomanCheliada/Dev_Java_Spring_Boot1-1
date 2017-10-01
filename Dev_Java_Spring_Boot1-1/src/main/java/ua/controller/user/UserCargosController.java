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

import ua.model.filter.CargoFilter;
import ua.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class UserCargosController {
	
	private final CargoService service;
	
	public UserCargosController(CargoService service) {
		this.service = service;
	}

	@ModelAttribute("cargoFilter")
	public CargoFilter getFilter(){
		return new CargoFilter();
	}
	
	@GetMapping
	public String show(Model model,Principal principal, @PageableDefault Pageable pageable, @ModelAttribute("cargoFilter") CargoFilter filter){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("cargos", service.findAll(pageable, filter));
		model.addAttribute("citys", service.findAllCity());
		return "allCargos";
	}
	
	@GetMapping("/clean")
	public String clean(@PageableDefault Pageable pageable, @ModelAttribute("cargoFilter") CargoFilter filter){
		return "redirect:/cargos"+buildParams(pageable,filter);
		
	}
	
	private String buildParams(Pageable pageable, CargoFilter filter) {
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
