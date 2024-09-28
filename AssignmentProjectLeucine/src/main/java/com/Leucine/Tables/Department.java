package com.Leucine.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

	@Id
	private int id;
	private String dname;
	private String des;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
}
