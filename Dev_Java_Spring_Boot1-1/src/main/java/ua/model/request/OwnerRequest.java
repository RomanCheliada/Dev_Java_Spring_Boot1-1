package ua.model.request;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueEmail;

public class OwnerRequest {
	
	@UniqueEmail(message="User with this email was found on DB!")
	@NotBlank(message="Should not be empty!")
	private String email;
	
	@NotBlank(message="Should not be empty!")
	private String password;
	
	@NotBlank(message="Should not be empty!")
	private String repeatPassword;
	
	private String count;
	
	@NotBlank(message="Should not be empty!")
	private String name;
	
	@NotBlank(message="Should not be empty!")
	private String phone;
	
	@NotBlank(message="Should not be empty!")
	private String address;
	

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
