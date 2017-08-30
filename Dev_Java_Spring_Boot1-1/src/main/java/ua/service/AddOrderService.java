package ua.service;

import java.security.Principal;
import java.util.List;

import ua.model.request.CargoRequest;

public interface AddOrderService {
	
	List<String> findAllGoods();

	List<String> findAllCity();
	
	void save(CargoRequest request, Principal principal);
	
	

}
