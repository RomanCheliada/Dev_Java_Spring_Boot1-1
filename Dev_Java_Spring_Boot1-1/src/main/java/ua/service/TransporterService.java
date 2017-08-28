package ua.service;

import java.util.List;

import ua.model.view.TransporterView;


public interface TransporterService{
	
	List<String> findAllModels();
	
	void delete(Integer id);
	
	List<TransporterView> findAllView();
	

}
