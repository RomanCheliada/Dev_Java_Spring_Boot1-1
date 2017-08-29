package ua.service;

import java.util.List;

import ua.model.view.OwnerView;

public interface OwnerService{
	
	List<OwnerView> findAll();
	
	void delete(Integer id);
	
	OwnerView findOneView(Integer id);

}
