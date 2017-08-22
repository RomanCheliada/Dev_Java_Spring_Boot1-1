package ua.service;

import java.util.List;

import ua.entity.Transporter;


public interface TransporterService{
	
	List<String> findAllBrands();
	
	List<String> findAllModels();
	
	void delete(Integer id);

}
