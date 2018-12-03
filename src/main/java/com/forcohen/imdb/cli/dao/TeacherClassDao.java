package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.forcohen.imdb.cli.models.TeacherClass;

public class TeacherClassDao {
	Connection conn;
	ResultSet rs;
	
	public TeacherClassDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
	public TeacherClassDao findAll() {
		try {
			Statement query = conn.createStatement();
			
			ResultSet rs = query.executeQuery("select * from \"professores_materias\"");
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void save(TeacherClass teacherClass) {
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"professores_materias\" (id_professor, id_materia) values (?, ?)");
			query.setInt(1, teacherClass.getIdProfessor());
			query.setInt(2, teacherClass.getIdMateria());

			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
