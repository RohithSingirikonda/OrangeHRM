package com.Temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HRM.base.TestBase;

public class DatabaseTesting extends TestBase{

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		try{
		
		Connection conn;
		String dbUrl = "jdbc:mysql://rohithsingirikonda.tk:3306/rohiths_orangehrm_mysql";
		//Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, "rohiths_temp", "Admin@123");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery( "select * from ohrm_user" );
		
		while (rs.next()) {
			System.out.println(rs.getString("id")+","+rs.getString("name"));
			
		}
		
		if(conn!=null)
		System.out.println("Successfull");
		else
		System.out.println("Database connection failed");
		
		}catch (SQLException ex) {
		      System.out.println("An error occurred while connecting MySQL databse");
		      ex.printStackTrace();
	    }
			    
	}

}
