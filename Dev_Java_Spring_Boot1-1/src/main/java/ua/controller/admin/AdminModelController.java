package ua.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import ua.model.filter.ModelFilter;
import ua.model.filter.SimpleFilter;
import ua.model.request.ModelRequest;
import ua.service.ModelService;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class AdminModelController {
	
	private final ModelService service;

	@Autowired
	public AdminModelController(ModelService service) {
		this.service = service;
	}
	
	@ModelAttribute("model")
	public ModelRequest getForm(){
		return new ModelRequest();
	}
	
	@ModelAttribute("modelFilter")
	public ModelFilter getFormFilter(){
		return new ModelFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("modelFilter") ModelFilter filter){
		model.addAttribute("models", service.findAll(pageable,filter));
		model.addAttribute("brands", service.findAllBrands());
		return "model";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, @ModelAttribute("modelFilter") ModelFilter filter2){
		service.delete(id);
		return "redirect:/admin/model"+buildParams(pageable,filter2);
	}
	
	@PostMapping
	public String save(@ModelAttribute("model") @Valid ModelRequest model, BindingResult br, SessionStatus status, Model model2, @PageableDefault Pageable pageable, @ModelAttribute("modelFilter") ModelFilter filter){
		if(br.hasErrors()) return show(model2,pageable,filter);
		service.save(model);
		return cancel(status,pageable,filter);
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("modelFilter") ModelFilter filter){
		model.addAttribute("model", service.findOneRequest(id));
		return show(model,pageable,filter);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("modelFilter") ModelFilter filter) {
		status.setComplete();
		return "redirect:/admin/model"+buildParams(pageable,filter);
	}
	
	@GetMapping("/clean")
	public String clean(@PageableDefault Pageable pageable,@ModelAttribute("modelFilter") ModelFilter filter){
		return "redirect:/admin/model"+buildParams(pageable,filter);
		
	}
	
	private String buildParams(Pageable pageable, ModelFilter filter) {
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
