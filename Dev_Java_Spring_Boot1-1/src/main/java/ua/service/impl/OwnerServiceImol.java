package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Owner;
import ua.repository.OwnerRepository;
import ua.service.OwnerService;
@Service
public class OwnerServiceImol extends CrudServiceImpl<Owner, Integer> implements OwnerService{
@Autowired
	public OwnerServiceImol(OwnerRepository repository) {
		super(repository);
	}

}
