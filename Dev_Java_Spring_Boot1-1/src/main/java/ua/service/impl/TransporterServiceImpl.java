package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.model.view.TransporterView;
import ua.repository.TransporterRepository;
import ua.service.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService {
	


	private final TransporterRepository repository;

	public TransporterServiceImpl(TransporterRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<String> findAllModels() {
		return repository.findAllModels();
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);	}


	@Override
	public List<TransporterView> findAllView() {
		return repository.findAllView();
	}


	


}
