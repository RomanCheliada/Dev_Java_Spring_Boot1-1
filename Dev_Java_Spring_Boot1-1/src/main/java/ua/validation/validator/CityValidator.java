package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.CityRepository;
import ua.validation.annotation.UniqueCity;

@Component
public class CityValidator implements ConstraintValidator<UniqueCity, String>{
	
	private final CityRepository repository;
	
	public CityValidator(CityRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueCity constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return repository.findByName(value.trim())==null;
	}

}
