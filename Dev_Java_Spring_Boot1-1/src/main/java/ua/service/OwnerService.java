package ua.service;

import java.util.List;

import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerService{
	
	List<OwnerView> findAll();
	
	void delete(Integer id);
	
	OwnerView findOneView(Integer id);
	
	OwnerView findOnePrincipalView(String name);
	
	Owner nameOwner(String name);
	
	
}
