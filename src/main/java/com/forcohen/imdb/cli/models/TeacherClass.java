package com.forcohen.imdb.cli.models;

public class TeacherClass {
	int idProfessor;
	int idMateria;
	
	public TeacherClass() {
		super();
	}
	
	public TeacherClass(int idProfessor, int idMateria) {
		super();
		this.idProfessor = idProfessor;
		this.idMateria = idMateria;
	}
	
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
}
