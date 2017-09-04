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

import ua.entity.Goods;
import ua.service.GoodsService;

@Controller
@RequestMapping("/admin/goods")
@SessionAttributes("goods")
public class AdminGoodsController {
	
	private final GoodsService service;

	@Autowired
	public AdminGoodsController(GoodsService service) {
		this.service = service;
	}
	
	@ModelAttribute("goods")
	public Goods getForm(){
		return new Goods();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("goodss", service.findAll());
		return "goods";
	}
	
	@GetMapping("/goods/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/goods";
	}
	
	@PostMapping
	public String save(@ModelAttribute("goods") @Valid Goods goods,BindingResult br, SessionStatus status, Model model){
		if(br.hasErrors()) return show(model);
		service.save(goods);
		return cancel(status);
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("goods", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/goods";
	}
}
