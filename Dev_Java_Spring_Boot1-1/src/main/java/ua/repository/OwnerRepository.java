package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Owner;
import ua.model.view.OwnerView;

public interface OwnerRepository extends JpaNameRepository<Owner, Integer>{

	@Query(value="SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address) FROM Owner o ",
			countQuery="SELECT count(o.id) FROM Owner o ")
	Page<OwnerView> findAllView(Pageable pageable);
	
	@Query("SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address) FROM Owner o WHERE o.id=?1")
	OwnerView findOneView(Integer id);
	
	@Query("SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address) FROM Owner o JOIN o.user u WHERE u.email=?1")
	OwnerView findOnePrincipalView(String name);
	
	@Query("SELECT o FROM Owner o JOIN o.user u WHERE u.email=?1")
	Owner findOwner(String name);
	
	
}
