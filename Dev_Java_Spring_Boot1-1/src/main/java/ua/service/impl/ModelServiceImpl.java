package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Model;
import ua.repository.ModelRepository;
import ua.service.ModelService;
@Service
public class ModelServiceImpl extends CrudServiceImpl<Model, Integer> implements ModelService{
@Autowired
	public ModelServiceImpl(ModelRepository repository) {
		super(repository);
	}

}
