package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.forcohen.imdb.cli.models.Review;

public class ReviewDao {
	Connection conn;
	ResultSet rs;
	
	public ReviewDao(Connection conn) {
		this.conn = conn;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
	public ReviewDao findAll() {
		try {
			Statement query = conn.createStatement();
			
			ResultSet rs = query.executeQuery("select * from \"resenhas\"");
			
			this.rs = rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void save(Review review) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"resenhas\" (id_professor, id_materia, id_usuario, resenha, estrelas, data_resenha, ano_periodo, mes_periodo) values (?, ?, ?, ?, ?, ?, ?, ?)");
			query.setInt(1, review.getIdTeacher());
			query.setInt(2, review.getIdClass());
			query.setInt(3, review.getIdUser());
			query.setString(4, review.getReview());
			query.setInt(5, review.getStars());
			query.setDate(6, new Date(new java.util.Date().getTime()));
			query.setInt(7, review.getYear());
			query.setInt(8, review.getMonth());
			
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
