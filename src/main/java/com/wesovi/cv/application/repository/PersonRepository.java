package com.wesovi.cv.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wesovi.cv.application.model.Person;


public interface PersonRepository extends MongoRepository<Person,String>{
		
}
