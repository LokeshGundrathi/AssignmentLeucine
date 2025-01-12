package com.Leucine.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentTable {
	
	@Id
	@OneToOne
	@JoinColumn(name = "user_id")
private User123 user;
	
	@OneToOne
	@JoinColumn(name = "dept_id")
private Department dept;

	@OneToOne
	@JoinColumn(name = "cour_id")
private CourseTable cour;
private String year;
public User123 getUser() {
	return user;
}
public void setUser(User123 user) {
	this.user = user;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}
public CourseTable getCour() {
	return cour;
}
public void setCour(CourseTable cour) {
	this.cour = cour;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}





}
