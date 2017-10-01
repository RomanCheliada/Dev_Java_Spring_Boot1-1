package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Cargo;
import ua.entity.Owner;
import ua.entity.Transporter;
import ua.model.filter.CargoFilter;
import ua.model.filter.SimpleFilter;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;

public interface CargoService extends CrudService<Cargo, Integer>{

	List<String> findAllGoods();

	List<String> findAllCity();

	Page<CargoView> findAllView(Pageable pageable, SimpleFilter filter);

	void save(CargoRequest request);

	void delete(Integer id);

	CargoRequest findOneRequest(Integer id);
	
	CargoView findOneView(Integer id);

	Owner findOwnerView(Integer id);

	List<Transporter> findListTransporters(Integer id);

	void confirm(Integer cargoId, Integer transporterId);

	Page<CargoView> findAll(Pageable pageable, CargoFilter filter);
	

}
