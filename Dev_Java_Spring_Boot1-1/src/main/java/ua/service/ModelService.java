package ua.service;


import java.util.List;

import ua.entity.Model;
import ua.model.request.ModelRequest;

public interface ModelService {
	
	List<String> findAllBrands();
	
	void delete(Integer id);
	
	List<Model> findAll();
	
	ModelRequest findOne(Integer id);

	void save(ModelRequest request);
	
}
