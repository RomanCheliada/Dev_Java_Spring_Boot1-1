package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Owner;
import ua.model.view.CargoView;
import ua.model.view.OwnerView;
import ua.repository.OwnerRepository;
import ua.service.OwnerService;
@Service
public class OwnerServiceImpl implements OwnerService{
	
	private final OwnerRepository repositoriy;
	

	public OwnerServiceImpl(OwnerRepository repositoriy) {
		this.repositoriy = repositoriy;
	}


	@Override
	public Page<OwnerView> findAll(Pageable pageable) {
		return repositoriy.findAllView(pageable);
	}


	@Override
	public void delete(Integer id) {
		repositoriy.delete(id);
	}


	@Override
	public OwnerView findOneView(Integer id) {
		return repositoriy.findOneView(id);
	}


	@Override
	public Owner nameOwner(String name) {
		return repositoriy.findOwner(name);
	}


	@Override
	public OwnerView findOnePrincipalView(String name) {
		return repositoriy.findOnePrincipalView(name);
	}


	@Override
	public List<CargoView> findAllCargosPrincipalUser(String name) {
		return repositoriy.findAllCargosPrincipalUser(name);
	}


	@Override
	public Page<OwnerView> findAllView(Pageable pageable) {
		return repositoriy.findAllView(pageable);
	}



	
}
