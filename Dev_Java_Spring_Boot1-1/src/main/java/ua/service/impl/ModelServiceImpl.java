package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.Model;
import ua.model.request.ModelRequest;
import ua.repository.ModelRepository;
import ua.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService{

	
	private final ModelRepository repository;

	public ModelServiceImpl(ModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllBrands() {
		return repository.findAllBrands();
	}

	@Override
	public void save(ModelRequest request) {
		Model model = new Model();
		model.setBrand(request.getBrand());
		model.setId(request.getId());
		model.setName(request.getName());
		repository.save(model);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	public ModelRequest findOne(Integer id) {
		Model model = repository.findOneRequest(id);
		ModelRequest request = new ModelRequest();
		request.setBrand(model.getBrand());
		request.setId(model.getId());
		request.setName(model.getName());
		
		
		return request;
	}

	
	

}
