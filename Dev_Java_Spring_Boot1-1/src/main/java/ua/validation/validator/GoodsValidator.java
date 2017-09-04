package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.GoodsRepository;
import ua.validation.annotation.UniqueGoods;

@Component
public class GoodsValidator implements ConstraintValidator<UniqueGoods, String>{
	
	private final GoodsRepository repository;
	

	public GoodsValidator(GoodsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueGoods constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return repository.findByName(value.trim())==null;
	}

}
