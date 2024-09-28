package com.Leucine.Tables;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class EnrollmentTable {

	@Id
	private int id;
	@OneToOne
	private StudentTable s;
	@OneToOne
	private CourseTable c;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentTable getS() {
		return s;
	}
	public void setS(StudentTable s) {
		this.s = s;
	}
	public CourseTable getC() {
		return c;
	}
	public void setC(CourseTable c) {
		this.c = c;
	}
	
	
	
}
