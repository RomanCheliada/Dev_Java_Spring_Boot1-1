package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="goods")
public class Goods extends AbstractEntityName{
	
	@OneToMany(mappedBy="goods")
	@NotBlank(message="Should not be empty!")
	private List<Cargo> cargos = new ArrayList<>();
	
	
	
	public Goods() {
	}
	public Goods(String name) {
		super(name);
		
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	
	

}
