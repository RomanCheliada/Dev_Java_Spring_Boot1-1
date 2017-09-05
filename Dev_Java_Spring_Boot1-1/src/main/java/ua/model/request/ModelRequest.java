package ua.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Brand;

public class ModelRequest {
	
	private Integer id;
	
	@NotBlank(message="Should not be empty!")
	private String name;
	
	@NotNull(message="Should not be empty!")
	private Brand brand;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	

}
