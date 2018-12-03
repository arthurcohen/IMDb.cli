package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ClassDao {
	Connection conn;
	ResultSet rs;
	
	public ClassDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
	public ClassDao findAll() {
		try {
			Statement query = conn.createStatement();
			
			ResultSet rs = query.executeQuery("select * from \"materias\"");
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void save(com.forcohen.imdb.cli.models.Class classObj) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"materias\" (titulo, area, componente) values (?, ?, ?)");
			query.setString(1, classObj.getTitulo());
			query.setString(2, classObj.getArea());
			query.setString(3, classObj.getComponente());
			
			query.execute();
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
