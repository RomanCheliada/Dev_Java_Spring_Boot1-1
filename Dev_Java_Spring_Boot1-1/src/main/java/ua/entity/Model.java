package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;




@Entity
@Table(name="model")
public class Model extends AbstractEntityName{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotBlank(message="Should not be empty!")
	private Brand brand;

	
	@OneToMany(mappedBy="model")
	private List<Transporter> transporters = new ArrayList<>();
	

	public Model(String name, Brand brand) {
		super(name);
		this.brand = brand;
	}

	public Model() {
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public List<Transporter> getTransporters() {
		return transporters;
	}



	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}

	
}
