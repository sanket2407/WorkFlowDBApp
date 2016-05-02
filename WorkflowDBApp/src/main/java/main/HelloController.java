package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;
import model.Department;
import model.Helper;
import model.Layer;
import model.Level;
import model.Organization;
import model.RequestType;
import model.Role;
import model.Status;
import model.Test;
import model.User;
import model.Workflow;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {

		return "Greetings from Spring Boot!";
	}

	/*
	 * {"role_name" : "depart_admin"}
	 */
	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createRole(@RequestBody Role role) {

		Connection conn = new DBConnection().getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO role ( name) VALUES ('" + role.getRole_name() + "')";

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

		return new ResponseEntity<Object>(role, HttpStatus.CREATED);
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

		Helper helper = new Helper();

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			department.setOrg_id(helper.getOrgIDFromAdminEmail(department.getAdmin_email()));

			if (department.getOrg_id() != -1) {

				sql = "INSERT INTO department ( name, org_id ) VALUES ('" + department.getDepartment_name() + "','"
						+ department.getOrg_id() + "')";

				System.out.println(sql);

				stmt.executeUpdate(sql);
			} else {
				return new ResponseEntity<Object>("Organization not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			}
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

	/*
	 * { "email_id": "bill@apple.com", "org_name": "Microsoft", "address":
	 * "101 E San", "dept_name": "Software", "password": "admin", "role_name":
	 * "depart_admin", "phones": [{ "phone": "0123456789" }, { "phone":
	 * "1234567890" }] }
	 */
	/*
	 * { "email_id": "parth@microsoft.com", "org_name": "Microsoft", "address":
	 * "111 E San", "dept_name": "Software", "password": "admin", "role_name":
	 * "user", "phones": [{ "phone": "0123456789" }, { "phone": "1234567890" }]
	 * }
	 */
	@RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> userSignUp(@RequestBody User user) {

		Helper helper = new Helper();

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			user.setOrg_id(helper.getOrgIDFromOrgName(user.getOrg_name()));
			user.setDept_id(helper.getDeptIDFromDeptName(user.getDept_name()));
			user.setRole_id(helper.getRoleFromRoleName(user.getRole_name()));

			if (user.getOrg_id() == -1) {
				return new ResponseEntity<Object>("Organization not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			} else if (user.getDept_id() == -1) {
				return new ResponseEntity<Object>("Department not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			} else if (user.getRole_id() == -1) {
				return new ResponseEntity<Object>("Role not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				sql = "INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('"
						+ user.getEmail_id() + "','" + user.getOrg_id() + "','" + user.getPassword() + "','"
						+ user.getAddress() + "','" + user.getDept_id() + "','" + user.getRole_id() + "')";

				System.out.println(sql);
				stmt.executeUpdate(sql);

				Object obj = user.getPhones();

				List<LinkedHashMap> list = (ArrayList<LinkedHashMap>) obj;
				for (int i = 0; i < list.size(); i++) {
					sql = "INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('" + user.getEmail_id() + "','"
							+ user.getOrg_id() + "','" + list.get(i).get("phone") + "')";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}

			}
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

		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	/*
	 * { "email_id" : "bill@microsoft.com", "password" : "admin",
	 * "org_name":"Microsoft"}
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> userLogin(@RequestBody User user) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			user.setOrg_id(helper.getOrgIDFromOrgName(user.getOrg_name()));

			sql = "SELECT password FROM user where email_id='" + user.getEmail_id() + "' and org_id="
					+ user.getOrg_id();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				// Retrieve by column name
				String pass = rs.getString("password");

				if (pass.equals(user.getPassword())) {
					return new ResponseEntity<Object>(user, HttpStatus.OK);
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
	 * { "email_id" : "bill@microsoft.com", "request_type_name" : "code review",
	 * "org_name":"Microsoft"}
	 */
	@RequestMapping(value = "/createRequestType", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createRequestType(@RequestBody RequestType requestType) {

		Helper helper = new Helper();

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			requestType.setOrg_id(helper.getOrgIDFromOrgName(requestType.getOrg_name()));

			if (requestType.getOrg_id() == -1) {
				return new ResponseEntity<Object>("Organization not exists", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				sql = "INSERT INTO request_type ( name, email_id, org_id ) VALUES ('"
						+ requestType.getRequest_type_name() + "','" + requestType.getEmail_id() + "','"
						+ requestType.getOrg_id() + "')";

				System.out.println(sql);
				stmt.executeUpdate(sql);

			}
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

		return new ResponseEntity<Object>(requestType, HttpStatus.OK);
	}

	/*
	 * { "level_name" : "Level 0", "description" : "requester-level" }
	 */
	@RequestMapping(value = "/createLevel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createLevel(@RequestBody Level level) {

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO level ( name, description ) VALUES ('" + level.getLevel_name() + "','"
					+ level.getDescription() + "')";

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

		return new ResponseEntity<Object>(level, HttpStatus.OK);
	}

	/*
	 * { "layer_name" : "Layer 0", "description" : "First Worker" }
	 */
	@RequestMapping(value = "/createLayer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createLayer(@RequestBody Layer layer) {

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO layer ( name, description ) VALUES ('" + layer.getLayer_name() + "','"
					+ layer.getDescription() + "')";

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

		return new ResponseEntity<Object>(layer, HttpStatus.OK);
	}

	/*
	 * { "status_name" : "Pending", "description" :
	 * "Request is in pending state." }
	 */
	@RequestMapping(value = "/createStatus", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createStatus(@RequestBody Status status) {

		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO status ( name, description ) VALUES ('" + status.getStatus_name() + "','"
					+ status.getDescription() + "')";

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

		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}

	/*
	 * { "email_id" : "bill@microsoft.com", "request_type_name" : "code review",
	 * "org_name":"Microsoft", "description" : "Code review request for Bill",
	 * "department_name" : "Software" }
	 */
	@RequestMapping(value = "/createWorkflow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createWorkflow(@RequestBody Workflow workflow) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			workflow.setDept_id(helper.getDeptIDFromDeptName(workflow.getDepartment_name()));
			workflow.setOrg_id(helper.getOrgIDFromOrgName(workflow.getOrg_name()));
			workflow.setRequest_type_id(helper.getRequestTypeIDFromRequestTypeName(workflow.getRequest_type_name()));

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO workflow_master ( description, request_type_id, email_id, org_id, dept_id ) VALUES ('"
					+ workflow.getDescription() + "','" + workflow.getRequest_type_id() + "','" + workflow.getEmail_id()
					+ "','" + workflow.getOrg_id() + "','" + workflow.getDept_id() + "')";

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

		return new ResponseEntity<Object>(workflow, HttpStatus.OK);
	}

	/*
	 * /addIntoWorkflow /select based on user id /select based on department
	 * admin /select based on workflow id
	 * 
	 * /create request /actionOnWorkflow
	 */

	/*
	 * { "workflow_id" : "1", "worker_email_id" : "bill@microsoft.com",
	 * "worker_org_name":"Microsoft", "description" :
	 * "level 1 for code review workflow", "level_name": "Level 1"}
	 */
	@RequestMapping(value = "/addLevelIntoWorkflow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> addLevelIntoWorkflow(@RequestBody Workflow workflow) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {
			
			workflow.setWorker_org_id(helper.getOrgIDFromOrgName(workflow.getWorker_org_name()));
			workflow.setOrg_id(helper.getOrgIDFromOrgName(workflow.getOrg_name()));
			workflow.setLevel_id(helper.getLevelIDFromLevelName(workflow.getLevel_name()));
			workflow.setLayer_id(helper.getLayerIDFromLayerName("Layer 1"));
			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ("
					+ "'" + workflow.getWorkflow_id() + "','" + workflow.getLevel_id() + "','" + workflow.getWorker_email_id()
					+ "','" + workflow.getWorker_org_id() + "','" + workflow.getLayer_id() + "','" + workflow.getDescription()
					+ "')";

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

		return new ResponseEntity<Object>(workflow, HttpStatus.OK);
	}

	/*
	 * { "workflow_id" : "1", "worker_email_id" : "parth@microsoft.com",
	 * "worker_org_name":"Microsoft", "description" :
	 * "layer 2 for code review workflow", "level_name": "Level 1", "layer_name": "Layer 2"}
	 */
	@RequestMapping(value = "/addLayerIntoWorkflow", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> addLayerIntoWorkflow(@RequestBody Workflow workflow) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {
			
			workflow.setWorker_org_id(helper.getOrgIDFromOrgName(workflow.getWorker_org_name()));
			workflow.setOrg_id(helper.getOrgIDFromOrgName(workflow.getOrg_name()));
			workflow.setLevel_id(helper.getLevelIDFromLevelName(workflow.getLevel_name()));
			workflow.setLayer_id(helper.getLayerIDFromLayerName(workflow.getLayer_name()));

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ("
					+ "'" + workflow.getWorkflow_id() + "','" + workflow.getLevel_id() + "','" + workflow.getWorker_email_id()
					+ "','" + workflow.getWorker_org_id() + "','" + workflow.getLayer_id() + "','" + workflow.getDescription()
					+ "')";

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

		return new ResponseEntity<Object>(workflow, HttpStatus.OK);
	}
	
	
	
	// ==========================================================

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> test(@RequestBody Test test) {

		return new ResponseEntity<Object>(test, HttpStatus.OK);
	}

}
