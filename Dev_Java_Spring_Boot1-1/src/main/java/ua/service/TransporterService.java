package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Cargo;
import ua.model.filter.TransporterFilter;
import ua.model.request.TransporterRequest;
import ua.model.view.TransporterIndexView;
import ua.model.view.TransporterView;


public interface TransporterService{
	
	List<String> findAllModels();
	
	List<String> findAllBrands();
	
	List<String> findAllCitys();
	
	void delete(Integer id);
	
	Page<TransporterIndexView> findAllIndexView(Pageable pageable);
	
	List<TransporterView> findAllView();
	
	TransporterRequest findOnePrincipal(String email);
	
	TransporterView findOneView(Integer id);

	TransporterView findOnePrincipalView(String name);

	void changeStatus(String email);
	
	Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable);
	
	void takeJob(Integer id, String email);

	Cargo findCurrentCargo(String name);

	


}
