package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cargo;
import ua.entity.Transporter;
import ua.model.view.TransporterIndexView;
import ua.model.view.TransporterView;

public interface TransporterRepository extends JpaNameRepository<Transporter, Integer>{
	
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();
	
	@Query("SELECT b.name FROM Brand b")
	List<String> findAllBrands();
	
	@Query("SELECT c.name FROM City c")
	List<String> findAllCitys();

	@Query("SELECT new ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count,t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive,t.status) FROM Transporter t LEFT JOIN t.model m LEFT JOIN m.brand b LEFT JOIN t.cityArrive c")
	List<TransporterView> findAllView();

	@Query("SELECT t FROM Transporter t JOIN t.user u JOIN FETCH t.model m JOIN FETCH m.brand b WHERE u.email=?1")
	Transporter findOnePrincipal(String email);

	@Query("SELECT new ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count,t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive,t.status) FROM Transporter t LEFT JOIN t.model m LEFT JOIN m.brand b LEFT JOIN t.cityArrive c WHERE t.id=?1")
	TransporterView findOneView(Integer id);
	
	@Query("SELECT new  ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count,t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive,t.status) FROM Transporter t JOIN t.user u JOIN t.model m JOIN m.brand b JOIN t.cityArrive c WHERE u.email=?1 ")
	TransporterView findOnePrincipalView(String name);

	@Query(value="SELECT new ua.model.view.TransporterIndexView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name,t.count) FROM Transporter t ",
			countQuery="SELECT count(t.id) FROM Transporter t")
	Page<TransporterIndexView> findAllIndexView(Pageable pageable);

	@Query("SELECT t FROM Transporter t JOIN t.user u WHERE u.email=?1")
	Transporter findByEmail(String email);

	@Query("SELECT c FROM Transporter t JOIN t.cargo c JOIN FETCH c.goods g JOIN FETCH c.cityFrom cFrom JOIN FETCH c.cityTo cTo JOIN t.user u WHERE u.email=?1")
	Cargo findCurrentCargo(String name);
}
