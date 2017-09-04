package ua.model.request;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Brand;
import ua.entity.Model;
import ua.entity.Status;

public class TransporterRequest {
	
	@NotBlank(message="Should not be empty!")
	private String email;
	
	@NotBlank(message="Should not be empty!")
	private String password;
	
	@NotBlank(message="Should not be empty!")
	private String repeatPassword;
	
	@NotBlank(message="Should not be empty!")
	private String name;
	
	private String count;
	
	@NotBlank(message="Should not be empty!")
	private String maxWeight;
	
	@NotBlank(message="Should not be empty!")
	private String age;
	
	@NotBlank(message="Should not be empty!")
	private String phone;
	
	private Model model;
	
	private Brand brand;
	
	@NotBlank(message="Should not be empty!")
	private String carAge;
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getCarAge() {
		return carAge;
	}

	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}
	
	

}
