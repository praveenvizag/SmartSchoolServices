package com.smartschool.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartschool.services.manager.StudentRegistrationManager;
import com.smartschool.services.model.Students;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author pkonchada
 *
 */
@CrossOrigin(value = "*")
@RestController
public class StudentsController {

	@Autowired
	private StudentRegistrationManager studentRegistrationManager;

	/**
	 * @param studentsData
	 * @return
	 */
	@ApiOperation(value = "Student Registration with list of courses")
	@PostMapping(value = "/saveStudents", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Students> saveStudents(@RequestBody Students studentsData) {
		studentRegistrationManager.save(studentsData);
		return new ResponseEntity<>(studentsData, HttpStatus.CREATED);
	}

	/**
	 * @return
	 */
	@ApiOperation(value = "Get All Students who Registred for different courses")
	@GetMapping(value = "/getStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Students>> getStudents() {
		List<Students> findAll = studentRegistrationManager.findAll();
		return new ResponseEntity<List<Students>>(findAll, HttpStatus.OK);
	}

	/**
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "Test API")
	@GetMapping(value = "dummy/{name}")
	public String getResponse(@PathVariable("name") String name) {
		return "Welcome " + name;
	}

	/**
	 * @return
	 */
	@ApiOperation(value = "Delete All the Students")
	@DeleteMapping(value = "deleteAll")
	public ResponseEntity<String> deleteAll() {
		try {
			studentRegistrationManager.deleteAll();
			return new ResponseEntity<String>("Deleted Successfuly", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error while deleting", HttpStatus.OK);
		}

	}

	/**
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "Get All the Students By Name")
	@GetMapping(value = "/getStudentByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Students>> getStudentByName(@PathVariable("name") String name) {
		List<Students> findAll = studentRegistrationManager.findByName(name.toLowerCase());
		return new ResponseEntity<List<Students>>(findAll, HttpStatus.OK);
	}
}
