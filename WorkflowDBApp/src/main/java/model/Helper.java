package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databaseConnection.DBConnection;

public class Helper {
	
	DBConnection dbCon;
	Connection conn;
	Statement stmt;
	
	public int getOrgIDFromAdminEmail(String admin_email){

		int org_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT org_id FROM organization where admin_email='" + admin_email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getOrgIDFromAdminEmail returned: "+ rs.getInt("org_id"));
				return rs.getInt("org_id");
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // end finally try
		} // end try
		
		return org_id;
	}
	
	public int getOrgIDFromOrgName(String org_name){

		int org_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT org_id FROM organization where name='" + org_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getOrgIDFromAdminEmail returned: "+ rs.getInt("org_id"));
				return rs.getInt("org_id");
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // end finally try
		} // end try
		
		return org_id;
	}
	
	public int getDeptIDFromDeptName(String dept_name){
		int dept_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT dept_id FROM department where name='" + dept_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getDeptIDFromDeptName returned: "+ rs.getInt("dept_id"));
				return rs.getInt("dept_id");
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // end finally try
		} // end try
			
		return dept_id;
	}
	
	public int getRoleFromRoleName(String role_name){
		int role_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT role_id FROM role where name='" + role_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getRoleFromRoleName returned: "+ rs.getInt("role_id"));
				return rs.getInt("role_id");
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // end finally try
		} // end try
		
		return role_id;
	}
	
	public int getRequestTypeIDFromRequestTypeName(String requestType_name){
		int request_type_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT request_type_id FROM request_type where name='" + requestType_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getRequestTypeIDFromRequestTypeName returned: "+ rs.getInt("request_type_id"));
				return rs.getInt("request_type_id");
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // end finally try
		} // end try
		
		return request_type_id;
	}
	
	

}
