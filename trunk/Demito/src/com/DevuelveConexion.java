package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DevuelveConexion {

	String port="3306";
	String username="root";
	String password="root";
	String portNumber="mysql";
	String dbName="test";
	
	public Connection getConnection() throws SQLException {

		Connection conn = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+dbName+"?user="+username+";password="+password);
	
		    System.out.println("Connected to database");
		    try {
				conn.close();
				System.out.println("Cerrando conexion!!!!!!");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("error generado por: "+e.getMessage());
		}


	    return conn;
	}
}
