package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.request.TransporterRequest;
import ua.model.view.TransporterIndexView;
import ua.model.view.TransporterView;


public interface TransporterService{
	
	List<String> findAllModels();
	
	void delete(Integer id);
	
	Page<TransporterIndexView> findAllIndexView(Pageable pageable);
	
	List<TransporterView> findAllView();
	
	TransporterRequest findOnePrincipal(String email);
	
	TransporterView findOneView(Integer id);

	Object findOnePrincipalView(String name);
	


}
