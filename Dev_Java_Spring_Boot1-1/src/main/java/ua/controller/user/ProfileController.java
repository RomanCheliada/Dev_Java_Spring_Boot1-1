package ua.controller.user;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.OwnerService;
import ua.service.TransporterService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	private final TransporterService tService;
	
	private final OwnerService oService;
	

	
	public ProfileController(TransporterService tService, OwnerService oService) {
		this.tService = tService;
		this.oService = oService;
	}


	@GetMapping
	public String show(Model model, Principal principal){
		if(principal!=null){
			model.addAttribute("message",principal.getName());
		}
		String authority = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority();
		if(authority.equals("ROLE_TRANSPORTER")){
			model.addAttribute("transporter", tService.findOnePrincipalView(principal.getName()));
			model.addAttribute("transporter_cargo", tService.findCurrentCargo(principal.getName()));
		}else if(authority.equals("ROLE_OWNER")){
			model.addAttribute("owner", oService.findOnePrincipalView(principal.getName()));
			model.addAttribute("cargos",oService.findAllCargosPrincipalUser(principal.getName()));
		}
		return "profile";
	}
	
	

	@GetMapping("/changeStatus")
	public String changeStatus(Principal principal){
		tService.changeStatus(principal.getName());
		return "redirect:/profile";
	}
}
