package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.greg.fmea.beans.SevStyle;
import org.greg.fmea.beans.Severity;
import org.greg.fmea.beans.SeverityGroup;
import org.greg.fmea.utils.C;

public class SeverityDAO {
	
	public static ArrayList<Severity> getAll() {
		ArrayList<Severity> sevs = new ArrayList<Severity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SEVERITY");
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				sevs.add(new Severity(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return sevs;
	}
	
	public static ArrayList<Severity> getAllByStyleId(int styleId) {
		ArrayList<Severity> sevs = new ArrayList<Severity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SEVERITY WHERE SEV_STYLE_ID = " + styleId);
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				sevs.add(new Severity(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return sevs;
	}
	
	public static ArrayList<SeverityGroup> getSeverityGroups() {
		SevStyle ss;
		ArrayList<SeverityGroup> sevGroups = new ArrayList<SeverityGroup>();
		
		ArrayList<SevStyle> allSevStyles = SevStyleDAO.getAll();
		Iterator<SevStyle> it = allSevStyles.iterator();
		while (it.hasNext()) {
			ss = it.next();
			//System.out.println("SeverityDAO: " + ss.getId() + ", " + ss.getName() + ", " + ss.getDescription());
			sevGroups.add(new SeverityGroup(ss, SeverityDAO.getAllByStyleId(ss.getId())));
		}
		
		return (sevGroups);
	}
	
	public static Severity getByID(int i) {
		Severity sev = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SEVERITY WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				sev = new Severity(rs.getInt(1), rs.getInt(2), rs.getString(2), rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return sev;
	}
	
	public static int addSeverity(int _value, String _description, int _sevStyleId) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("INSERT INTO SEVERITY (value, description, sev_style_id) values(" + _value + ",\"" + _description + "\"," + _sevStyleId + ")");
			//System.out.println("Result of inserting " + _value + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static int deleteSeverity(int id) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("DELETE FROM SEVERITY WHERE ID = " + id);
			//System.out.println("Result of deleting sev id " + id + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static void main(String[] args) {
		SeverityDAO.getSeverityGroups();
	}

}
