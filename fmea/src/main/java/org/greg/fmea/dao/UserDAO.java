package org.greg.fmea.dao;

import java.sql.*;
import java.util.ArrayList;

import org.greg.fmea.beans.User;
import org.greg.fmea.utils.C;

public class UserDAO {
	
	public static ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
			while (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) 
				//					+ ", " + rs.getString(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getInt(8));
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
									rs.getString(7), (rs.getInt(8)==1)));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return users;
	}
	
	public static User getByID(int i) {
		User user = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE ID=" + i);
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) 
				//					+ ", " + rs.getString(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getInt(8));
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
									rs.getString(7), (rs.getInt(8)==1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return user;
	}
	
	public static int addUser(String _firstname, String _lastname, String _sso, String _email, String _username, String _password, boolean _isAdmin) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("INSERT INTO USER (FIRST_NAME, LAST_NAME, SSO, EMAIL_ADDRESS, USERNAME, PASSWORD, IS_ADMIN) values(\"" + 
										_firstname + "\",\"" + _lastname + "\",\"" + _sso + "\",\"" + _email + "\",\"" + _username + "\",\"" +
										_password + "\",\"" + (_isAdmin ? "1" : "0") + "\")");
			//System.out.println("Result of inserting " + _firstname + " " + _lastname + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static int deleteUser(int id) {
		
		int rows = -1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			rows = stmt.executeUpdate("DELETE FROM USER WHERE ID = " + id);
			//System.out.println("Result of deleting user id " + id + ": " + rows);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return rows;
	}
	
	public static User getByUsername(String _username) {
		
		User user = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(C.dbURL, C.dbUser, C.dbPwd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE USERNAME=\"" + _username + "\"");
			if (rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) 
				//					+ ", " + rs.getString(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getInt(8));
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
									rs.getString(7), (rs.getInt(8)==1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
		
		return user;
	}
	
	public static void main(String[] args) {
		//UserDAO.addUser("Samantha", "Derzay", "123456789", "samantha.derzay@ge.com", "samantha", "samantha", false);
		//UserDAO.deleteUser(3);
		//UserDAO.getAll();
		
		String u = "jean";
		User user = UserDAO.getByUsername(u);
		if (null == user) {
			System.out.println("Username does not exist");
		} else {
			System.out.println("Password for " + u + ": " + user.getPassword());
		}
	}

}
