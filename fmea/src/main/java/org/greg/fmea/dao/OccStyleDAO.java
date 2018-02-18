package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;

import org.greg.fmea.beans.OccStyle;
import org.greg.fmea.utils.C;

public class OccStyleDAO {
	
	public static ArrayList<OccStyle> getAll() {
		ArrayList<OccStyle> occStyles = new ArrayList<OccStyle>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OCC_STYLE");
			while (rs.next()) {
				//System.out.println("OccStyleDAO: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				occStyles.add(new OccStyle(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return occStyles;
	}
	
	public static OccStyle getByID(int i) {
		OccStyle os = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OCC_STYLE WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				os = new OccStyle(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return os;
	}
	
	public static String getNameByID(int i) {
		String nm = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NAME FROM OCC_STYLE WHERE ID=" + i);
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
		OccStyleDAO.getAll();
	}

}
