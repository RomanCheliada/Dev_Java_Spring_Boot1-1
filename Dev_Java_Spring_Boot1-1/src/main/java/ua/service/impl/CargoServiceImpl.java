package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.entity.Transporter;
import ua.model.filter.CargoFilter;
import ua.model.filter.SimpleFilter;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;
import ua.repository.CargoRepository;
import ua.repository.CargoViewRepository;
import ua.repository.TransporterRepository;
import ua.service.CargoService;

@Service
public class CargoServiceImpl extends CrudServiceImpl<Cargo, Integer> implements CargoService{

	private final CargoRepository repository;
	
	private final TransporterRepository trRepository;
	
	private final CargoViewRepository viewRepository;
	
	public CargoServiceImpl(CargoRepository repository, TransporterRepository trRepository, CargoViewRepository viewRepository) {
		super(repository);
		this.repository = repository;
		this.trRepository = trRepository;
		this.viewRepository = viewRepository;
	}

	@Override
	public List<String> findAllGoods() {
		return repository.findAllGoods();
	}

	@Override
	public List<String> findAllCity() {
		return repository.findAllCity();
	}

	@Override
	public Page<CargoView> findAllView(Pageable pageable, SimpleFilter filter) {
		return repository.findAllView(pageable);
	}

	@Override
	public void save(CargoRequest request) {
		Cargo cargo = new Cargo();
		cargo.setCityFrom(request.getCityFrom());
		cargo.setCityTo(request.getCityTo());
		cargo.setGoods(request.getGoods());
		cargo.setHeight(Integer.valueOf(request.getHeight()));
		cargo.setId(request.getId());
		cargo.setLength(Integer.valueOf(request.getLength()));
		cargo.setOwner(request.getOwner());
		cargo.setPrice(new BigDecimal(request.getPrice().replace(',', '.')));
		cargo.setWeight(Integer.valueOf(request.getWeight()));
		cargo.setWidth(Integer.valueOf(request.getWidth()));
		repository.save(cargo);
	}

	@Override
	public CargoRequest findOneRequest(Integer id) {
		Cargo cargo = repository.findOneRequest(id);
		CargoRequest request = new CargoRequest();
		request.setCityFrom(cargo.getCityFrom());
		request.setCityTo(cargo.getCityTo());
		request.setGoods(cargo.getGoods());
		request.setHeight(String.valueOf(cargo.getHeight()));
		request.setId(cargo.getId());
		request.setLength(String.valueOf(cargo.getLength()));
		request.setOwner(cargo.getOwner());
		request.setPrice(String.valueOf(cargo.getPrice()));
		request.setWeight(String.valueOf(cargo.getWeight()));
		request.setWidth(String.valueOf(cargo.getWidth()));
		return request;
	}
	
	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public CargoView findOneView(Integer id) {
		return repository.findOneView(id);
	}

	@Override
	public Owner findOwnerView(Integer id) {
		return repository.findOwnerView(id);
	}

	@Override
	public List<Transporter> findListTransporters(Integer id) {
		Cargo cargo=repository.findOne(id);
		List<Transporter> transporters = cargo.getTransporters();
		return transporters;
	}

	@Override
	public void confirm(Integer cargoId, Integer transporterId) {
		Transporter transporter = trRepository.findOne(transporterId);
		Cargo cargo = repository.findOne(cargoId);
		cargo.setTransporter(transporter);
		transporter.setCargo(cargo);
		transporter.getCargos().clear();
		cargo.getTransporters().clear();
		trRepository.save(transporter);
		repository.save(cargo);
		
		
	}

	@Override
	public Page<CargoView> findAll(Pageable pageable, CargoFilter filter) {
		return viewRepository.findAll(filter, pageable);
	}

	@Override
	public void deleteFromList(Integer cargoId, Integer transporterId) {
		Transporter transporter = trRepository.findOne(transporterId);
		Cargo cargo = repository.findOne(cargoId);
		cargo.getTransporters().remove(transporter);
	}





}