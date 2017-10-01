package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Model;
import ua.model.filter.ModelFilter;
import ua.model.request.ModelRequest;
import ua.model.view.ModelView;
import ua.repository.ModelRepository;
import ua.repository.ModelViewRepository;
import ua.service.ModelService;
@Service
public class ModelServiceImpl extends CrudServiceImpl<Model, Integer> implements ModelService{

	
	private final ModelRepository repository;
	
	private final ModelViewRepository viewRepository;

	public ModelServiceImpl(ModelRepository repository,ModelViewRepository viewRepository) {
		super(repository);
		this.repository = repository;
		this.viewRepository = viewRepository;
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
	public List<ModelView> findAllView() {
		return repository.findAllView();
	}

	@Override
	public ModelRequest findOneRequest(Integer id) {
		Model model = repository.findOneRequest(id);
		ModelRequest request = new ModelRequest();
		request.setBrand(model.getBrand());
		request.setId(model.getId());
		request.setName(model.getName());
		
		
		return request;
	}

	@Override
	public Page<Model> findAllView(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<ModelView> findAll(Pageable pageable, ModelFilter filter) {
		return viewRepository.findAll(pageable,filter);
	}


	

}
