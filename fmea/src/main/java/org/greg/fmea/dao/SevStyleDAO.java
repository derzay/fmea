package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;

import org.greg.fmea.beans.SevStyle;
import org.greg.fmea.utils.C;

public class SevStyleDAO {
	
	public static ArrayList<SevStyle> getAll() {
		ArrayList<SevStyle> sevStyles = new ArrayList<SevStyle>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SEV_STYLE");
			while (rs.next()) {
				//System.out.println("SevStyleDAO: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				sevStyles.add(new SevStyle(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return sevStyles;
	}
	
	public static SevStyle getByID(int i) {
		SevStyle ss = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SEV_STYLE WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				ss = new SevStyle(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return ss;
	}
	
	public static String getNameByID(int i) {
		String nm = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM SEV_STYLE WHERE ID=" + i);
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
		SevStyleDAO.getAll();
	}

}
