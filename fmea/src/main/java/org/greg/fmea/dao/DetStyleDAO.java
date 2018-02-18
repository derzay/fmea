package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;

import org.greg.fmea.beans.DetStyle;
import org.greg.fmea.utils.C;

public class DetStyleDAO {
	
	public static ArrayList<DetStyle> getAll() {
		ArrayList<DetStyle> detStyles = new ArrayList<DetStyle>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DET_STYLE");
			while (rs.next()) {
				//System.out.println("DetStyleDAO: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				detStyles.add(new DetStyle(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return detStyles;
	}
	
	public static DetStyle getByID(int i) {
		DetStyle ds = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DET_STYLE WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				ds = new DetStyle(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return ds;
	}
	
	public static String getNameByID(int i) {
		String nm = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM DET_STYLE WHERE ID=" + i);
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
	
	public static void main(String[] args) {
		DetStyleDAO.getAll();
	}

}
