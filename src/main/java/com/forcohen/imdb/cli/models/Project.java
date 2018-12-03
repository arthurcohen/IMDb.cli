package com.forcohen.imdb.cli.models;

public class Project {
	int idTeacher;
	String title;
	String area;
	int semester;
	int year;
	
	public Project() {
		super();
	}

	public Project(int idTeacher, String title, String area, int semester, int year) {
		super();
		this.idTeacher = idTeacher;
		this.title = title;
		this.area = area;
		this.semester = semester;
		this.year = year;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
