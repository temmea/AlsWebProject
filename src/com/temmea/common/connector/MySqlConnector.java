package com.temmea.common.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
	
	static Connection connection = null;
	private static String sqlUrl = "jdbc:mysql://localhost:3306/al_schema1?";;
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(getSqlUrl() + "user=temmea&password=myWeakAssPassword");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 

		return connection;
	}
	
	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getSqlUrl(){
		return sqlUrl;
	}

}
