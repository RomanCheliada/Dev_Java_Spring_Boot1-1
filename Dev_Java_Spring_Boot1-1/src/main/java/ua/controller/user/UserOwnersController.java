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

import ua.model.filter.OwnerFilter;
import ua.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class UserOwnersController {
	
	private final OwnerService service;

	public UserOwnersController(OwnerService service) {
		this.service = service;
	}
	
	@ModelAttribute("ownerFilter")
 	public OwnerFilter getFilter() {
 		return new OwnerFilter();
 	}
	
	@GetMapping
	public String show(Model model, Principal principal,@ModelAttribute("ownerFilter") OwnerFilter filter, @PageableDefault Pageable pageable){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		model.addAttribute("owners", service.findAll(pageable,filter));
		return "allOwners";
	}
	
	@GetMapping("/clean")
	public String clean(@PageableDefault Pageable pageable,@ModelAttribute("ownerFilter") OwnerFilter filter){
		return "redirect:/owners"+buildParams(pageable,filter);
		
	}
	
	
	private String buildParams(Pageable pageable, OwnerFilter filter) {
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
