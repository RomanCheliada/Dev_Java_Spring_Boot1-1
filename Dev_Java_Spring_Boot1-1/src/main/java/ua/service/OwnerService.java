package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Owner;
import ua.model.view.CargoView;
import ua.model.view.OwnerView;

public interface OwnerService{
	
	Page<OwnerView> findAll(Pageable pageable);
	
	void delete(Integer id);
	
	OwnerView findOneView(Integer id);
	
	OwnerView findOnePrincipalView(String name);
	
	Owner nameOwner(String name);

	List<CargoView> findAllCargosPrincipalUser(String name);

	Page<OwnerView> findAllView(Pageable pageable);
	
	
}
