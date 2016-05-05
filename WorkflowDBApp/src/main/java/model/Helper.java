package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databaseConnection.DBConnection;

public class Helper {

	DBConnection dbCon;
	Connection conn;
	Statement stmt;

	public int getOrgIDFromAdminEmail(String admin_email) {

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
				System.out.println(">>> getOrgIDFromAdminEmail returned: " + rs.getInt("org_id"));
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

	public int getOrgIDFromOrgName(String org_name) {

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
				System.out.println(">>> getOrgIDFromAdminEmail returned: " + rs.getInt("org_id"));
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

	public int getDeptIDFromDeptName(String dept_name) {
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
				System.out.println(">>> getDeptIDFromDeptName returned: " + rs.getInt("dept_id"));
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

	public int getRoleFromRoleName(String role_name) {
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
				System.out.println(">>> getRoleFromRoleName returned: " + rs.getInt("role_id"));
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
	
	public String getRoleNameFromRoleId(int role_id) {
		String role_name = "";
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name FROM role where role_id='" + role_id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getRoleNameFromRoleId returned: " + rs.getString("name"));
				return rs.getString("name");
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

		return role_name;
	}


	public int getRequestTypeIDFromRequestTypeName(String requestType_name) {
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
				System.out.println(">>> getRequestTypeIDFromRequestTypeName returned: " + rs.getInt("request_type_id"));
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

	public int getLevelIDFromLevelName(String level_name) {
		int level_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT level_id FROM level where name='" + level_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getRequestTypeIDFromRequestTypeName returned: " + rs.getInt("level_id"));
				return rs.getInt("level_id");
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

		return level_id;
	}

	public int getLayerIDFromLayerName(String layer_name) {
		int layer_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT layer_id FROM layer where name='" + layer_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getLayerIDFromLayerName returned: " + rs.getInt("layer_id"));
				return rs.getInt("layer_id");
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

		return layer_id;
	}

	public int getStatusIDFromStatusName(String status_name) {
		int status_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT status_id FROM status where name='" + status_name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getStatusIDFromStatusName returned: " + rs.getInt("status_id"));
				return rs.getInt("status_id");
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

		return status_id;
	}

	public int getNewWorkflowInstanceId() {
		int workflow_instance_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT max(workflow_instance_id) as workflow_instance_id FROM workflowinstance";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				if (rs.getInt("workflow_instance_id") == 0) {
					workflow_instance_id = 1;
				} else {
					workflow_instance_id = rs.getInt("workflow_instance_id") + 1;
				}
				System.out.println(">>> getStatusIDFromStatusName returned: " + workflow_instance_id);
				return workflow_instance_id;
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

		return workflow_instance_id;
	}

	public int getMaxLevel_id(int workflow_instance_id) {
		int getMaxLevel_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT max(level_id) as max_level_id FROM workflowinstance where workflow_instance_id = '"
					+ workflow_instance_id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				return rs.getInt("max_level_id");
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

		return getMaxLevel_id;
	}

	public int getWorkflowIDFromWorkflowInstanceID(int workflow_instance_ID) {
		int workflow_ID = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT workflow_id FROM workflowinstance where workflow_instance_id='" + workflow_instance_ID
					+ "' group by workflow_id";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getWorkflowIDFromWorkflowInstanceID returned: " + rs.getInt("workflow_id"));
				return rs.getInt("workflow_id");
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

		return workflow_ID;
	}

	public int getDeptIDFromUserEmail(String user_email) {

		int dept_id = -1;
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT dept_id FROM user where email_id ='" + user_email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getDeptIDFromUserEmail returned: " + rs.getInt("dept_id"));
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
	
	public String getDeptNameFromDeptID(int dept_id) {

		String dept_name = "";
		dbCon = new DBConnection();
		conn = dbCon.getConnection();
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name FROM department where dept_id ='" + dept_id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(">>> getDeptNameFromDeptID returned: " + rs.getString("name"));
				return rs.getString("name");
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

		return dept_name;
	}
	
	public String getHexData(String input) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		System.out.println("password in hex format : " + sb.toString());

		return sb.toString();
	}
	
	

}
