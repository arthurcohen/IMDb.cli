package com.forcohen.imdb.cli.models;

import java.util.Date;

public class Teacher {
	private String name;
	private String area;
	private Date birth;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String area, Date birth) {
		super();
		this.name = name;
		this.area = area;
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
