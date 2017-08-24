package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Owner;
import ua.repository.OwnerRepository;
import ua.service.OwnerService;
@Service
public class OwnerServiceImpl extends CrudServiceImpl<Owner, Integer> implements OwnerService{
@Autowired
	public OwnerServiceImpl(OwnerRepository repository) {
		super(repository);
	}

}
