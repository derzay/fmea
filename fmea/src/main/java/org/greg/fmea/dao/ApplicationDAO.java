package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.greg.fmea.beans.Application;
import org.greg.fmea.utils.C;

public class ApplicationDAO {
	
	public static ArrayList<Application> getAll() {
		ArrayList<Application> apps = new ArrayList<Application>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM APPLICATION");
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				apps.add(new Application(rs.getInt(1), rs.getString(2)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return apps;
	}
	
	public static Application getByID(int i) {
		Application app = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM APPLICATION WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				app = new Application(rs.getInt(1), rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return app;
	}
	
	public static String getNameByID(int i) {
		String nm = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM APPLICATION WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getString(1));
				nm = rs.getString(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return nm;
	}
	
	public static int addApplication(String app) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("INSERT INTO APPLICATION (name) values(\"" + app + "\")");
			//System.out.println("Result of inserting " + app + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static int deleteApplication(int id) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("DELETE FROM APPLICATION WHERE ID = " + id);
			//System.out.println("Result of deleting app id " + id + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static void main(String[] args) {
		ArrayList<Application> apps = ApplicationDAO.getAll();
		Application app; 
		
		Iterator<Application> appsIterator = apps.iterator();
		while (appsIterator.hasNext()) {
			app = appsIterator.next();
			System.out.println(app.getId() + ", " + app.getName());
		}
	}

}
