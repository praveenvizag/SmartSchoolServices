package com.smartschool.services.manager;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.smartschool.services.dao.StudentsDAO;
import com.smartschool.services.model.Students;

@Service
public interface StudentRegistrationManager extends StudentsDAO {

	List<Students> findByName(String name);

	
}
