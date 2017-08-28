package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Transporter;
import ua.model.view.TransporterView;

public interface TransporterRepository extends JpaNameRepository<Transporter, Integer>{
	
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();

	@Query("SELECT new ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count,t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive,t.status) FROM Transporter t LEFT JOIN t.model m LEFT JOIN m.brand b LEFT JOIN t.cityArrive c")
	List<TransporterView> findAllView();


}
