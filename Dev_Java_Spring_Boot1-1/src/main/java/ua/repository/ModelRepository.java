package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Model;

public interface ModelRepository extends JpaNameRepository<Model, Integer>{
	
	@Query("SELECT b.name FROM Brand b")
	List<String> findAllBrands();
	
	@Query("SELECT new ua.model.view.ModelView(m.id,m.name,b.name) FROM Model m LEFT JOIN m.brand b")
	List<Model> findAll();

	@Query("SELECT m FROM Model m JOIN FETCH m.brand WHERE m.id=?1")
	Model findOneRequest(Integer id);
}
