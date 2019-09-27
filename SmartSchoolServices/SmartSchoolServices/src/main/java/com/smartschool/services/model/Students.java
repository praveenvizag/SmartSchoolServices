package com.smartschool.services.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Students {

	@Id
	private String id;
	@TextIndexed
	private String name;
	private Integer grade;
	private Integer age;
	private LocalDate joiningDate = LocalDate.now();
	private List<Subjects> coursesRegistered = new ArrayList<Subjects>();
	private GuardianData guardianData;
	private AddressData addressData;


	public GuardianData getGuardianData() {
		return guardianData;
	}

	public void setGuardianData(GuardianData guardianData) {
		this.guardianData = guardianData;
	}

	public AddressData getAddressData() {
		return addressData;
	}

	public void setAddressData(AddressData addressData) {
		this.addressData = addressData;
	}

	public List<Subjects> getCoursesRegistered() {
		return coursesRegistered;
	}

	public void setCoursesRegistered(List<Subjects> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		if (joiningDate != null) {
			this.joiningDate = joiningDate;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Students [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", age=");
		builder.append(age);
		builder.append(", joiningDate=");
		builder.append(joiningDate);
		builder.append(", coursesRegistered=");
		builder.append(coursesRegistered);
		builder.append(", guardianData=");
		builder.append(guardianData);
		builder.append(", addressData=");
		builder.append(addressData);
		builder.append("]");
		return builder.toString();
	}

	




}
