package com.forcohen.imdb.cli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String url = "jdbc:postgresql://localhost/arthur";
	String user = "postgres";
	String password = "admin";
	private Connection conn;
	
	public ConnectionFactory connect() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return this;
	}
	
	public Connection getInstance() throws NullPointerException {
		if (conn != null) {
			return conn;
		}
		
		throw new NullPointerException("Connection closed or never opened");
	}
}
