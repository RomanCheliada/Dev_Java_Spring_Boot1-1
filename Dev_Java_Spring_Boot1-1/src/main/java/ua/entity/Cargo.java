package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="cargo")
public class Cargo extends AbstractEntity{
	
	@NotNull(message="Should not be empty!")
	@ManyToOne(fetch=FetchType.LAZY)
	private Goods goods;
	
	@NotBlank(message="Should not be empty!")
	private int weight;
	
	@NotBlank(message="Should not be empty!")
	private int height;
	
	@NotBlank(message="Should not be empty!")
	private int width;
	
	@NotBlank(message="Should not be empty!")
	private int length;
	
	@NotNull(message="Should not be empty!")
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityFrom;
	
	@NotNull(message="Should not be empty!")
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityTo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Owner owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Transporter transporter;
	
	@ManyToMany
	@JoinTable(name="cargo_transporters", joinColumns=@JoinColumn(name="id_cargo"), inverseJoinColumns=@JoinColumn(name="id_transporter"))
	private List<Transporter> transporters = new ArrayList<>();
	
	
	@NotBlank(message="Should not be empty!")
	private BigDecimal price;
	
//	private boolean hasTransporter;
//	
//	@PrePersist
//	@PreUpdate
//	public void check(){
//		hasTransporter=(transporter!=null);
//	}

	public Cargo(Goods goods, int weight, int height, int width, int length, City cityFrom, City cityTo,
			BigDecimal price) {
		this.goods = goods;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.price = price;
	}
	
	

	public Cargo() {
	}


	public Transporter getTransporter() {
		return transporter;
	}



	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}



	public List<Transporter> getTransporters() {
		return transporters;
	}



	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}



	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public City getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}

	public City getCityTo() {
		return cityTo;
	}

	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	} 
	
	
	
	

}
