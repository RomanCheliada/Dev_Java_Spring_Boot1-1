package ua.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add-order")
public class UserAddOrderController {
	
	@GetMapping
	public String show(){
		return "add-order";
	}

}
