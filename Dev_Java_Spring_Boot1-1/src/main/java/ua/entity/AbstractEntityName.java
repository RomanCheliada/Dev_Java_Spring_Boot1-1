package ua.entity;

import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueBrand;
import ua.validation.annotation.UniqueCity;
import ua.validation.annotation.UniqueGoods;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{
	
	@UniqueBrand(message="Such brand exist on DB!")
	@UniqueCity(message="Such city exist on DB!")
	@UniqueGoods(message="Such goods exist on DB!")
	@NotBlank(message="Should not be empty!")
	private String name;

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public AbstractEntityName() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
