package ua.service;

import java.util.List;

import ua.model.request.TransporterRequest;
import ua.model.view.TransporterIndexView;
import ua.model.view.TransporterView;


public interface TransporterService{
	
	List<String> findAllModels();
	
	void delete(Integer id);
	
	List<TransporterIndexView> findAllIndexView();
	
	List<TransporterView> findAllView();
	
	TransporterRequest findOnePrincipal(String email);
	
	TransporterView findOneView(Integer id);

	Object findOnePrincipalView(String name);
	


}
