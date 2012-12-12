package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Demito {

	private	static String 			portMySQL		="3306";
	private static String 			usernameMySQL	="root";
	private static String 			passwordMySQL	="root";
	private static String 			dbName			="seccd_all";
	private static Connection 		conn 			= null;
	private static String 			clasForNameDB2	= "com.ibm.db2.jcc.DB2Driver";
	private static String			dataBase		="SECCD";
	private static String			userCasa		="seccd";
	private static String			userUnique		="db2admin";
	private static String			pswdCasa		="seccd";
	private static String			pswdUnique		="Pa$$w0rd1";
	
	public static void main(String[] args) {

		PreparedStatement   		pstmt 		= null;
		ResultSet 					rs 			= null;
		String venta1=null;
		String venta2=null;
		String cadena="2012-12-05";
		System.out.println(cadena.substring(0,4));
		System.out.println(cadena.substring(5,7));
		System.out.println(cadena.substring(8,10));
		
		/*
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:"+portMySQL+"/"+dbName+"?user="+usernameMySQL+";password="+passwordMySQL);

			StringBuffer query  = new StringBuffer();
			query.append("SELECT VENTA1,VENTA2 FROM VENTA");
			pstmt = conn.prepareStatement(query.toString());
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				venta1 = rs.getBigDecimal(1).toString();
				venta2 = rs.getBigDecimal(2).toString();
				
				//System.out.println(rs.getBigDecimal(1));
				//System.out.println(rs.getBigDecimal(2));
				System.out.println("venta1:"+venta1);
				System.out.println("venta2:"+venta2);
				
				System.out.println("**********");
			}
	    } catch (Exception e) {
			System.out.println("error generado por: "+e.getMessage());
		}
	    finally{
	    	try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
	    }*/
	}
}
