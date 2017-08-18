package ua.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Goods;
import ua.service.GoodsService;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	
	private final GoodsService service;

	public AdminGoodsController(GoodsService service) {
		this.service = service;
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
	public String name(@RequestParam String name){
		service.save(new Goods(name));
		return "redirect:/admin/goods";
	}
}
