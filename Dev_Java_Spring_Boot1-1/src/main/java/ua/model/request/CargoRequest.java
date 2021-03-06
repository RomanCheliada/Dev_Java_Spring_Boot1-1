package ua.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.City;
import ua.entity.Goods;
import ua.entity.Owner;

public class CargoRequest {
	
	private Integer id;
	
	@NotNull(message="Should not be empty!")
	private Goods goods;
	
	@NotBlank(message="Should not be empty!")
	private String weight;
	
	@NotBlank(message="Should not be empty!")
	private String height;
	
	@NotBlank(message="Should not be empty!")
	private String width;
	
	@NotBlank(message="Should not be empty!")
	private String length;
	
	@NotNull(message="Should not be empty!")
	private City cityFrom;
	
	@NotNull(message="Should not be empty!")
	private City cityTo;
	
	private Owner owner;
	
	@NotBlank(message="Should not be empty!")
	private String price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
