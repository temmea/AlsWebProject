package com.temmea.common.connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AlsConnectorClass {

	public static void main(String[] args) {
		Statement statement 	= null;
		ResultSet rs			= null;
		try {
			
			statement = MySqlConnector.getConnection().createStatement();
			rs = statement.executeQuery("select * from name");
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getInt(3));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				MySqlConnector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
