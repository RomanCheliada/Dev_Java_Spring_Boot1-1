package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerRepository extends JpaNameRepository<Owner, Integer>{

	@Query("SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address) FROM Owner o")
	List<OwnerView> findAllView();
	
	@Query("SELECT o FROM Owner o WHERE o.id=?1")
	OwnerView findOneView(Integer id);
}
