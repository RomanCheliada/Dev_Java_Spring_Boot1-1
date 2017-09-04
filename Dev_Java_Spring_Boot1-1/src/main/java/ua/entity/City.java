package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="city")
public class City extends AbstractEntityName{

	
	@OneToMany(mappedBy="cityArrive")
	private List<Transporter> transporters = new ArrayList<>();
	
	@OneToMany(mappedBy="cityFrom")
	@NotBlank(message="Should not be empty!")
	private List<Cargo> cargoFroms = new ArrayList<>();
	
	@OneToMany(mappedBy="cityTo")
	@NotBlank(message="Should not be empty!")
	private List<Cargo> cargoTo = new ArrayList<>();

	public City(String name) {
		super(name);
	}

	public City() {
	}


	public List<Transporter> getTransporters() {
		return transporters;
	}

	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}

	public List<Cargo> getCargoFroms() {
		return cargoFroms;
	}

	public void setCargoFroms(List<Cargo> cargoFroms) {
		this.cargoFroms = cargoFroms;
	}

	public List<Cargo> getCargoTo() {
		return cargoTo;
	}

	public void setCargoTo(List<Cargo> cargoTo) {
		this.cargoTo = cargoTo;
	}


}
