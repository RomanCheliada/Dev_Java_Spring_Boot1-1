package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Transporter;
import ua.model.request.TransporterRequest;
import ua.model.view.TransporterIndexView;
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
	public Page<TransporterIndexView> findAllIndexView(Pageable pageable) {
		return repository.findAllIndexView(pageable);
	}


	@Override
	public TransporterRequest findOnePrincipal(String email) {
		Transporter transporter = repository.findOnePrincipal(email);
		TransporterRequest request = new TransporterRequest();
		request.setAge(String.valueOf(transporter.getAge()));
		request.setCarAge(String.valueOf(transporter.getCarAge()));
		request.setEmail(transporter.getUser().getEmail());
		request.setMaxWeight(String.valueOf(transporter.getMaxWeight()));
		request.setModel(transporter.getModel());
		request.setName(transporter.getName());
		request.setBrand(transporter.getModel().getBrand());
		request.setCount(String.valueOf(transporter.getCount()));
		request.setPassword(transporter.getUser().getPassword());
		request.setPhone(String.valueOf(transporter.getPhone()));
		request.setStatus(transporter.getStatus());
		return request;
	}


	@Override
	public TransporterView findOneView(Integer id) {
		return repository.findOneView(id);
	}


	@Override
	public List<TransporterView> findAllView() {
		return repository.findAllView();
	}


	@Override
	public Object findOnePrincipalView(String name) {
		return repository.findOnePrincipalView(name);
	}


	


}
