package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportsDao {
	Connection conn;
	ResultSet rs;
	
	public ReportsDao(Connection conn) {
		this.conn = conn;
	}

	public ResultSet resultSet() {
		return rs;
	}
	
	public ReportsDao getTeachersReviews() {
		try {
			Statement stm = conn.createStatement();
			
			rs = stm.executeQuery("select * from professoresResenhas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public ReportsDao getTeachersReviewsMostStars() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from professorMateriaSomaEstrelas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ReportsDao getTeachersReviewsAverageStars() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from professorMateriaMediaEstrelas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	

	public ReportsDao getTeachersProjectsMostStars() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from projetosProfessoresSomaEstrelas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ReportsDao getTeachersClasses() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from todosProfessoresEMaterias");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ReportsDao getUsersReviews() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from usuariosResenhasDesc ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	

	public ReportsDao getClassesAreas() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from areasMaterias");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	

	public ReportsDao getTeachersAreas() {
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery("select * from areasProfessores");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	
}
