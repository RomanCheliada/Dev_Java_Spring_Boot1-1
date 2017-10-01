package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.entity.Status;
import ua.entity.Transporter;
import ua.model.filter.TransporterFilter;
import ua.model.request.TransporterRequest;
import ua.model.view.TransporterIndexView;
import ua.model.view.TransporterView;
import ua.repository.CargoRepository;
import ua.repository.TransporterRepository;
import ua.repository.TransporterViewRepository;
import ua.service.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService {

	private final TransporterRepository repository;
	
	private final TransporterViewRepository viewRepository;
	
	private final CargoRepository cargoRepository;
	
	public TransporterServiceImpl(TransporterRepository repository,TransporterViewRepository viewRepository,CargoRepository cargoRepository) {
		this.repository = repository;
		this.viewRepository = viewRepository;
		this.cargoRepository = cargoRepository;
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
	public TransporterView findOnePrincipalView(String name) {
		return repository.findOnePrincipalView(name);
	}


	@Override
	public void changeStatus(String email) {
		Transporter transporter = repository.findOnePrincipal(email);
		if(transporter.getStatus().equals((Status.FREE))) transporter.setStatus(Status.IN_THE_WAY);
		else if(transporter.getStatus().equals((Status.IN_THE_WAY))) transporter.setStatus(Status.FREE);
		repository.save(transporter);
	}

	@Override
	public List<String> findAllBrands() {
		return repository.findAllBrands();
	}

	@Override
	public List<String> findAllCitys() {
		return repository.findAllCitys();
	}

	@Override
	public Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable) {
		return viewRepository.findAll(filter, pageable);
	}

	@Override
	public void takeJob(Integer id, String email) {
		Transporter transporter = repository.findOnePrincipal(email);
		Cargo cargo = cargoRepository.findOne(id);
		cargo.getTransporters().add(transporter);
		cargoRepository.save(cargo);
		
	}

	@Override
	public Cargo findCurrentCargo(String name) {
		return repository.findCurrentCargo(name);
	}




	


}
