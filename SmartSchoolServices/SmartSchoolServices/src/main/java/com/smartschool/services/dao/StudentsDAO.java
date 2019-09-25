package com.smartschool.services.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartschool.services.model.Students;

public interface StudentsDAO extends MongoRepository<Students, Integer> {
	
	List<Students> findByName(String name);

}
