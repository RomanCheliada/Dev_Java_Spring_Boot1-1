package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Transporter;

public interface TransporterRepository extends JpaNameRepository<Transporter, Integer>{
	
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();

	

}
