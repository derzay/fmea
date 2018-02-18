package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.greg.fmea.beans.DetStyle;
import org.greg.fmea.beans.Detectability;
import org.greg.fmea.beans.DetectabilityGroup;
import org.greg.fmea.utils.C;

public class DetectabilityDAO {
	
	public static ArrayList<Detectability> getAll() {
		ArrayList<Detectability> dets = new ArrayList<Detectability>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DETECTABILITY");
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				dets.add(new Detectability(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return dets;
	}
	
	public static ArrayList<Detectability> getAllByStyleId(int detectabilityId) {
		ArrayList<Detectability> dets = new ArrayList<Detectability>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DETECTABILITY WHERE DET_STYLE_ID = " + detectabilityId);
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				dets.add(new Detectability(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return dets;
	}
	
	public static ArrayList<DetectabilityGroup> getDetectabilityGroups() {
		DetStyle ds;
		ArrayList<DetectabilityGroup> detGroups = new ArrayList<DetectabilityGroup>();
		
		ArrayList<DetStyle> allDetStyles = DetStyleDAO.getAll();
		Iterator<DetStyle> it = allDetStyles.iterator();
		while (it.hasNext()) {
			ds = it.next();
			//System.out.println("DetectabilityDAO: " + ds.getId() + ", " + ds.getName() + ", " + ds.getDescription());
			detGroups.add(new DetectabilityGroup(ds, DetectabilityDAO.getAllByStyleId(ds.getId())));
		}
		
		return (detGroups);
	}
	
	public static Detectability getByID(int i) {
		Detectability det = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DETECTABILITY WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				det = new Detectability(rs.getInt(1), rs.getInt(2), rs.getString(2), rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return det;
	}
	
	public static int addDetectability(int _value, String _description, int _detStyleId) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("INSERT INTO DETECTABILITY (value, description, det_style_id) values(" + _value + ",\"" + _description + "\"," + _detStyleId + ")");
			//System.out.println("Result of inserting " + _value + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static int deleteDetectability(int id) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("DELETE FROM DETECTABIITY WHERE ID = " + id);
			//System.out.println("Result of deleting det id " + id + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static void main(String[] args) {
		DetectabilityDAO.getDetectabilityGroups();
	}

}
