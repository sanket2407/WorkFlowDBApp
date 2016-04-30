package main;

import java.sql.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;
import model.Department;
import model.Organization;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {

		return "Greetings from Spring Boot!";
	}

	/*
	 * { "name" : "Microsoft", "address" : "Seattle", "admin_email" :
	 * "micro@micro.com", "password" : "admin" }
	 */
	@RequestMapping(value = "/orgAdminSignUp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> clientSignUp(@RequestBody Organization organization) {

		Connection conn = new DBConnection().getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO organization ( name, address, admin_email, password ) VALUES ('" + organization.getName()
					+ "','" + organization.getAddress() + "','" + organization.getAdmin_email() + "','"
					+ organization.getPassword() + "')";

			System.out.println(sql);

			stmt.executeUpdate(sql);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
				return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
				return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // end finally try
		} // end try

		return new ResponseEntity<Object>(organization, HttpStatus.CREATED);
	}

	/*
	 * { "admin_email" : "micro@micro.com", "password" : "admin" }
	 */
	@RequestMapping(value = "/orgAdminLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> clientLogin(@RequestBody Organization organization) {

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT password FROM organization where admin_email='" + organization.getAdmin_email() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				String pass = rs.getString("password");

				if (pass.equals(organization.getPassword())) {

					return new ResponseEntity<Object>(organization, HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>("Invalid username or password!", HttpStatus.BAD_REQUEST);
				}
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
				return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
				return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // end finally try
		} // end try
		return new ResponseEntity<Object>("Invalid username or password!", HttpStatus.BAD_REQUEST);
	}

	/*
	 * { "admin_email" : "micro@micro.com", "department_name" : "Software" }
	 */
	@RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createDepartment(@RequestBody Department department) {

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT org_id FROM organization where admin_email='" + department.getAdmin_email() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				System.out.println(rs.getInt("org_id"));
				department.setOrg_id(rs.getInt("org_id"));
			}
			if(department.getOrg_id()!= -1){
			sql = "INSERT INTO department ( name, org_id ) VALUES ('" + department.getDepartment_name()
					+ "','" + department.getOrg_id() + "')";

			System.out.println(sql);

			stmt.executeUpdate(sql);
			}
			else{
				return new ResponseEntity<Object>("Organization not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
				return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
				return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // end finally try
		} // end try
		return new ResponseEntity<Object>(department, HttpStatus.OK);
	}
	
	

}
