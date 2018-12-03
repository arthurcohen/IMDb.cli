package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.forcohen.imdb.cli.models.Teacher;

public class TeacherDao {
	Connection conn;
	ResultSet rs;
	
	public TeacherDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
	public TeacherDao findAll() {
		try {
			Statement query = conn.createStatement();
			
			ResultSet rs = query.executeQuery("select * from \"professores\"");
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void save(Teacher teacher) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"professores\" (nome, area, nascimento) values (?, ?, ?)");
			query.setString(1, teacher.getName());
			query.setString(2, teacher.getArea());
			query.setDate(3, new Date(teacher.getBirth().getTime()));
			
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
