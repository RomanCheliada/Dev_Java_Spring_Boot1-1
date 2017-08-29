package ua.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.model.request.CargoRequest;
import ua.repository.CargoRepository;
import ua.repository.OwnerRepository;
import ua.service.AddOrderService;

public class AddOrderServiceImpl implements AddOrderService{
	
	private final CargoRepository repository;
	
	private final Principal principal;
	
	private final OwnerRepository ownerRepository;
	


	public AddOrderServiceImpl(CargoRepository repository, Principal principal, OwnerRepository ownerRepository) {
		this.repository = repository;
		this.principal = principal;
		this.ownerRepository = ownerRepository;
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
//		Owner owner = ownerRepository.findByName(principal.getName());
		Owner owner = repository.findPrincipalOwner(principal.getName());
		cargo.setOwner(owner);
		repository.save(cargo);
		
	}

}
