package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.greg.fmea.beans.OccStyle;
import org.greg.fmea.beans.Occurrence;
import org.greg.fmea.beans.OccurrenceGroup;
import org.greg.fmea.utils.C;

public class OccurrenceDAO {
	
	public static ArrayList<Occurrence> getAll() {
		ArrayList<Occurrence> occs = new ArrayList<Occurrence>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OCCURRENCE");
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				occs.add(new Occurrence(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return occs;
	}
	
	public static ArrayList<Occurrence> getAllByStyleId(int occurrenceId) {
		ArrayList<Occurrence> occs = new ArrayList<Occurrence>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OCCURRENCE WHERE OCC_STYLE_ID = " + occurrenceId);
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3) + ", " + rs.getInt(4));
				occs.add(new Occurrence(rs.getInt(4), rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return occs;
	}
	
	public static ArrayList<OccurrenceGroup> getOccurrenceGroups() {
		OccStyle os;
		ArrayList<OccurrenceGroup> occGroups = new ArrayList<OccurrenceGroup>();
		
		ArrayList<OccStyle> allOccStyles = OccStyleDAO.getAll();
		Iterator<OccStyle> it = allOccStyles.iterator();
		while (it.hasNext()) {
			os = it.next();
			//System.out.println("OccurrenceDAO: " + os.getId() + ", " + os.getName() + ", " + os.getDescription());
			occGroups.add(new OccurrenceGroup(os, OccurrenceDAO.getAllByStyleId(os.getId())));
		}
		
		return (occGroups);
	}
	
	public static Occurrence getByID(int i) {
		Occurrence occ = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OCCURRENCE WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				occ = new Occurrence(rs.getInt(1), rs.getInt(2), rs.getString(2), rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return occ;
	}
	
	public static int addOccurrence(int _value, String _description, int _occStyleId) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("INSERT INTO OCCURRENCE (value, description, occ_style_id) values(" + _value + ",\"" + _description + "\"," + _occStyleId + ")");
			//System.out.println("Result of inserting " + _value + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static int deleteOccurrence(int id) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("DELETE FROM OCCURRENCE WHERE ID = " + id);
			//System.out.println("Result of deleting occ id " + id + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static void main(String[] args) {
		OccurrenceDAO.getOccurrenceGroups();
	}

}
