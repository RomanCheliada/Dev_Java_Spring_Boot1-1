package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<OwnerView> findAll() {
		return repositoriy.findAllView();
	}


	@Override
	public void delete(Integer id) {
		repositoriy.delete(id);
	}


	@Override
	public OwnerView findOneView(Integer id) {
		return repositoriy.findOneView(id);
	}

	
}
