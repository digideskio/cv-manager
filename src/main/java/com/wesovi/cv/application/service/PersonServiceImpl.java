package com.wesovi.cv.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovi.cv.application.model.Person;
import com.wesovi.cv.application.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	private final PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public void create(Person person) {
		this.personRepository.save(person);
	}

	@Override
	public void update(Person person) {
		this.personRepository.save(person);
		
	}

}
