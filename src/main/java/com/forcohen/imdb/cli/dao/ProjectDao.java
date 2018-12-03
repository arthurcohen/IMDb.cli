package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.forcohen.imdb.cli.models.Project;

public class ProjectDao {
	Connection conn;
	ResultSet rs;
	
	public ProjectDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
	public ProjectDao findAll() {
		try {
			Statement query = conn.createStatement();
			
			ResultSet rs = query.executeQuery("select * from \"projetos\"");
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void save(Project project) {
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"projetos\" (id_professor, titulo, area, ano_periodo, mes_periodo) values (?, ?, ?, ?, ?)");
			query.setInt(1, project.getIdTeacher());
			query.setString(2, project.getTitle());
			query.setString(3, project.getArea());
			query.setInt(4, project.getYear());
			query.setInt(5, project.getSemester());
			
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
