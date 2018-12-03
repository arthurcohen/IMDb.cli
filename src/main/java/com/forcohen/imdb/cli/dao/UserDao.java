package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.forcohen.imdb.cli.models.User;

public class UserDao {
	Connection conn;
	ResultSet rs;
	
	public UserDao(Connection conn) {
		this.conn = conn;
	}
	
	public UserDao save(User user) {
		try {
			PreparedStatement query = conn.prepareStatement("insert into \"usuarios\" (login, senha, resenhas) values (?, ?, ?)");
			query.setString(1, user.getLogin());
			query.setString(2, user.getPassword());
			query.setInt(3, 0);

			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public int login(User user) {
		int id = -1;
		try {
			PreparedStatement query = conn.prepareStatement("select coalesce((select id_usuario from usuarios where login = ? and senha = ?), -1) id_usuario");
			query.setString(1, user.getLogin());
			query.setString(2, user.getPassword());
			
			rs = query.executeQuery();
			
			if (rs.next())
				id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ResultSet resultSet() {
		return rs;
	}
	
}
