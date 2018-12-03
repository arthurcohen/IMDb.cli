package com.forcohen.imdb.cli.models;

public class Class {
	private String titulo;
	private String area;
	private String componente;
	
	public Class() {
		super();
	}

	public Class(String titulo, String area, String componente) {
		super();
		this.titulo = titulo;
		this.area = area;
		this.componente = componente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	
}
