package ua.service;

import java.util.List;

import ua.model.request.CargoRequest;

public interface AddOrderService {
	
	List<String> findAllGoods();

	List<String> findAllCity();
	
	void save(CargoRequest request);

}
