package ua.service;

import java.util.List;



public interface TransporterService{
	
	List<String> findAllModels();
	
	void delete(Integer id);

}
