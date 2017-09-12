package ua.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Model;
import ua.model.request.ModelRequest;
import ua.model.view.ModelView;

public interface ModelService extends CrudService<Model, Integer> {
	
	List<String> findAllBrands();
	
	void delete(Integer id);
	
	List<ModelView> findAllView();
	
	ModelRequest findOneRequest(Integer id);

	void save(ModelRequest request);

	Page<Model> findAllView(Pageable pageable);

	
}
