package com.Leucine.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class AdminstrationTable {

	@Id
	@OneToOne
	@JoinColumn(name = "user_id")
	private User123 user;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;
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
	
	
}
