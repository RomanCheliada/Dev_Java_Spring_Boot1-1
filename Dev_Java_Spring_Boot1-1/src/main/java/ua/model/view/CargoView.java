package ua.model.view;

import java.math.BigDecimal;

public class CargoView {
	
	private Integer id;
	
	private String goods;
	
	private int weight;
	
	private int height;
	
	private int width;
	
	private int length;
	
	private String cityFrom;
	
	private String cityTo;
	
	private String owner;
	
	private String transporter;
	
	private String price;
	
	public CargoView(Integer id, String goods, int weight, int height, int width, int length, String cityFrom, String cityTo,String owner,String transporter, BigDecimal price) {
		this.id = id;
		this.goods = goods;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.owner = owner;
		this.transporter = transporter;
		this.price = String.valueOf(price);
		
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
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

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	

}
