package com.smartschool.services.model;

public class Subjects {
	
	private String coursename;
	private String courseid;
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subjects [coursename=");
		builder.append(coursename);
		builder.append(", courseid=");
		builder.append(courseid);
		builder.append("]");
		return builder.toString();
	}
	
	

}
