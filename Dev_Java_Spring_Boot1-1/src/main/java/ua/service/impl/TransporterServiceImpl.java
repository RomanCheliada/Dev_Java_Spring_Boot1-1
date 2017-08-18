package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Transporter;
import ua.repository.TransporterRepository;
import ua.service.TransporterService;
@Service
public class TransporterServiceImpl extends CrudServiceImpl<Transporter, Integer> implements TransporterService{
@Autowired
	public TransporterServiceImpl(TransporterRepository repository) {
		super(repository);
	}

}
