package main;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import databaseConnection.DBConnection;
import model.AllDepartments;
import model.AllOrganizations;
import model.AllUnassignedDepartments;
import model.AllUsers;
import model.ApproveRequest;
import model.Department;
import model.Helper;
import model.Layer;
import model.Level;
import model.NextWorkers;
import model.Organization;
import model.RejectRequest;
import model.Request;
import model.RequestType;
import model.Role;
import model.Status;
import model.TakeRequest;
import model.Test;
import model.User;
import model.Workflow;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloController {

	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping("/")
	public String index() {

		return "Greetings from Workflow Management Project Team!";
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
	 * { "status_name" : "Requested", "description" :
	 * "Request is in requested state." }
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
	 * { "name" : "Microsoft", "address" : "Seattle", "admin_email"
	 * :"micro@micro.com", "password" : "admin" }
	 */
	@RequestMapping(value = "/orgAdminSignUp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> clientSignUp(@RequestBody Organization organization) throws NoSuchAlgorithmException {

		Helper helper = new Helper();
		Connection conn = new DBConnection().getConnection();
		Statement stmt = null;

		organization.setPassword(helper.getHexData(organization.getPassword()));

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
	public ResponseEntity<Object> clientLogin(@RequestBody Organization organization) throws NoSuchAlgorithmException {

		Helper helper = new Helper();
		organization.setPassword(helper.getHexData(organization.getPassword()));
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
	 * { "email_id": "bill@apple.com", "org_name": "Microsoft",
	 * "address":"101 E San", "dept_name": "Software", "password": "admin",
	 * "role_name":"depart_admin", "phones": [{ "phone": "0123456789" }, {
	 * "phone":"1234567890" }] }
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
			user.setPassword(helper.getHexData(user.getPassword()));

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
	public ResponseEntity<Object> userLogin(@RequestBody User user) throws NoSuchAlgorithmException {

		Helper helper = new Helper();
		user.setPassword(helper.getHexData(user.getPassword()));
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

					sql = "SELECT role_id FROM user where email_id='" + user.getEmail_id() + "' and org_id="
							+ user.getOrg_id();
					ResultSet rs1 = stmt.executeQuery(sql);
					System.out.println(sql);
					while (rs1.next()) {
						int role_id = rs1.getInt("role_id");
						user.setRole_id(role_id);
						user.setRole_name(new Helper().getRoleNameFromRoleId(user.getRole_id()));
					}

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

			// get newly created workflow id from database.

			sql = "SELECT workflow_id FROM workflow_master where request_type_id=" + workflow.getRequest_type_id()
					+ " and email_id = '" + workflow.getEmail_id() + "' and org_id = '" + workflow.getOrg_id()
					+ "' and dept_id= '" + workflow.getDept_id() + "'";

			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int workflow_id = rs.getInt("workflow_id");
				System.out.println("created workflow id is: " + workflow_id);
				workflow.setWorkflow_id(workflow_id);
			}

			workflow.setLevel_id(helper.getLevelIDFromLevelName("Level 0"));
			workflow.setLayer_id(helper.getLayerIDFromLayerName("Layer 0"));

			sql = "INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ("
					+ "'" + workflow.getWorkflow_id() + "','" + workflow.getLevel_id() + "','" + workflow.getEmail_id()
					+ "','" + workflow.getOrg_id() + "','" + workflow.getLayer_id() + "','" + workflow.getDescription()
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
	 * { "workflow_id" : "1", "worker_email_id" : "chinu@microsoft.com",
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
			workflow.setLayer_id(helper.getLayerIDFromLayerName("Layer 0"));

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ("
					+ "'" + workflow.getWorkflow_id() + "','" + workflow.getLevel_id() + "','"
					+ workflow.getWorker_email_id() + "','" + workflow.getWorker_org_id() + "','"
					+ workflow.getLayer_id() + "','" + workflow.getDescription() + "')";

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
	 * "layer 1 for code review workflow for level 1", "level_name": "Level 1",
	 * "layer_name": "Layer 1"}
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
					+ "'" + workflow.getWorkflow_id() + "','" + workflow.getLevel_id() + "','"
					+ workflow.getWorker_email_id() + "','" + workflow.getWorker_org_id() + "','"
					+ workflow.getLayer_id() + "','" + workflow.getDescription() + "')";

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
	 * { "workflow_id" : "1", "email_id" : "chinu@microsoft.com",
	 * "org_name":"Microsoft", "status_name": "Requested"}
	 */
	@RequestMapping(value = "/doRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> doRequest(@RequestBody Request request) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;
		try {

			request.setLevel_id(helper.getLevelIDFromLevelName(request.getLevel_name()));
			request.setLayer_id(helper.getLayerIDFromLayerName(request.getLayer_name()));
			request.setStatus_id(helper.getStatusIDFromStatusName(request.getStatus_name()));
			request.setDescription("Request initiated !");
			request.setWorkflow_instance_id(helper.getNewWorkflowInstanceId());
			request.setTimestamp();

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			sql = "INSERT INTO workflowinstance ( workflow_instance_id, workflow_id, level_id, layer_id, status_id, description, timestamp ) VALUES ("
					+ "'" + request.getWorkflow_instance_id() + "','" + request.getWorkflow_id() + "','"
					+ request.getLevel_id() + "','" + request.getLayer_id() + "','" + request.getStatus_id() + "','"
					+ request.getDescription() + "','" + request.getTimestamp() + "')";

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

		return new ResponseEntity<Object>(request, HttpStatus.OK);
	}

	/*
	 * {"workflow_instance_id": "1"}
	 */
	@RequestMapping(value = "/getNextWorkers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getNextWorkers(@RequestBody NextWorkers nextWorkers) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;

		// get current level
		nextWorkers.setCurrent_level_id(helper.getMaxLevel_id(nextWorkers.getWorkflow_instance_id()));
		nextWorkers.setWorkflow_id(helper.getWorkflowIDFromWorkflowInstanceID(nextWorkers.getWorkflow_instance_id()));

		// set new level id
		System.out.println("New level id is : " + nextWorkers.getCurrent_level_id() + 1);
		nextWorkers.setNew_level_id(nextWorkers.getCurrent_level_id() + 1);

		// get all approvers of next level
		List<Map<String, Object>> workers = new ArrayList<Map<String, Object>>();
		Map<String, Object> worker;

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT email_id, org_id, description, layer_id, level_id from workflow.workflowtbl where workflow_id = '"
					+ nextWorkers.getWorkflow_id() + "' and level_id = '" + nextWorkers.getNew_level_id() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);

			while (rs.next()) {

				String email = rs.getString("email_id");
				int org_id = rs.getInt("org_id");
				String description = rs.getString("description");
				int layer_id = rs.getInt("layer_id");
				int level_id = rs.getInt("level_id");

				worker = new HashMap<String, Object>();
				worker.put("email", email);
				worker.put("org_id", org_id);
				worker.put("description", description);
				worker.put("layer_id", layer_id);
				worker.put("level_id", level_id);
				workers.add(worker);
				nextWorkers.setTimestamp();

				stmt = conn.createStatement();

				sql = "INSERT INTO workflowinstance ( workflow_instance_id, workflow_id, level_id, layer_id, status_id, description, timestamp ) VALUES ("
						+ "'" + nextWorkers.getWorkflow_instance_id() + "','" + nextWorkers.getWorkflow_id() + "','"
						+ level_id + "','" + layer_id + "','" + helper.getStatusIDFromStatusName("Assigned") + "','"
						+ "Assigned!  " + description + "','" + nextWorkers.getTimestamp() + "')";

				System.out.println(sql);
				stmt.executeUpdate(sql);

			}

			nextWorkers.setWorkers(workers);

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

		return new ResponseEntity<Object>(nextWorkers, HttpStatus.OK);
	}

	/*
	 * { "workflow_instance_id": "1", "workflow_id" : "1", "email_id" :
	 * "chinu@microsoft.com", "org_name":"Microsoft", "level_id" : "2",
	 * "layer_id" : "1"}
	 */
	@RequestMapping(value = "/takeRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> takeRequest(@RequestBody TakeRequest takeRequest) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn1 = dbCon.getConnection();
		Connection conn2 = dbCon.getConnection();

		// disabling auto commit
		try {
			conn1.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Statement stmt1 = null;
		Statement stmt2 = null;
		try {

			// read status on the request

			System.out.println("Creating statement...");
			stmt1 = conn1.createStatement();
			String sql;

			takeRequest.setDescription("Pending! Working on request..!");
			takeRequest.setStatus("Pending");
			takeRequest.setStatus_id(helper.getStatusIDFromStatusName(takeRequest.getStatus()));
			takeRequest.setTimestamp();

			sql = " UPDATE workflowinstance SET timestamp = '" + takeRequest.getTimestamp() + "' , status_id='"
					+ takeRequest.getStatus_id() + "' , description = '" + takeRequest.getDescription()
					+ "' WHERE workflow_instance_id = '" + takeRequest.getWorkflow_instance_id()
					+ "' and  workflow_id = '" + takeRequest.getWorkflow_id() + "' and level_id = '"
					+ takeRequest.getLevel_id() + "' and layer_id = '" + takeRequest.getLayer_id() + "' ";

			System.out.println(sql);
			stmt1.executeUpdate(sql);
			System.out.println("Statement 1 executed");

			takeRequest.setPrev_status("Assigned");
			takeRequest.setPrev_status_id(helper.getStatusIDFromStatusName(takeRequest.getPrev_status()));

			Object obj = new Object();
			synchronized (obj) {

				// Verify the status of the request is still assigned to it or
				// not! If not then rollback else commit.

				stmt2 = conn2.createStatement();
				sql = "SELECT status_id FROM workflowinstance where workflow_instance_id = '"
						+ takeRequest.getWorkflow_instance_id() + "' and workflow_id = '" + takeRequest.getWorkflow_id()
						+ "' and level_id = '" + takeRequest.getLevel_id() + "' and layer_id = '"
						+ takeRequest.getLayer_id() + "' ";

				System.out.println(sql);
				ResultSet rs = stmt2.executeQuery(sql);
				System.out.println("Statement 2 executed");

				while (rs.next()) {
					// Retrieve by column name
					int current_status_id = rs.getInt("status_id");

					System.out.println("previous status id was: " + takeRequest.getPrev_status_id());
					System.out.println("current_status_id is: " + current_status_id);

					if (current_status_id == takeRequest.getPrev_status_id()) {
						System.out.println("Going to commit transactions.....!!");
						conn1.commit();
						System.out.println("Transaction commit finished.....!!");
					} else {
						System.out.println("Going to rollback transactions.....!!");
						conn1.rollback();
						System.out.println("Transaction rollback finished.....!!");
					}
				}

			}

			stmt1.close();
			stmt2.close();
			conn1.close();
			conn2.close();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			// finally block used to close resources
			try {
				if (stmt1 != null)
					stmt1.close();
				if (stmt2 != null)
					stmt2.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
				return new ResponseEntity<Object>(se1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // nothing we can do
			try {
				if (conn1 != null)
					conn1.close();
				if (conn2 != null)
					conn2.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
				return new ResponseEntity<Object>(se2.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			} // end finally try
		} // end try

		return new ResponseEntity<Object>(takeRequest, HttpStatus.OK);
	}

	/*
	 * { "workflow_instance_id": "1", "workflow_id" : "1", "email_id" :
	 * "chinu@microsoft.com", "org_name":"Microsoft", "level_id" : "2",
	 * "layer_id" : "1"}
	 */
	@RequestMapping(value = "/approveRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> approveRequest(@RequestBody ApproveRequest approveRequest) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();

		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			approveRequest.setDescription("Approved by :" + approveRequest.getEmail_id());
			approveRequest.setStatus("Approve");
			approveRequest.setStatus_id(helper.getStatusIDFromStatusName(approveRequest.getStatus()));
			approveRequest.setTimestamp();

			sql = " UPDATE workflowinstance SET timestamp = '" + approveRequest.getTimestamp() + "' , status_id='"
					+ approveRequest.getStatus_id() + "' , description = '" + approveRequest.getDescription()
					+ "' WHERE workflow_instance_id = '" + approveRequest.getWorkflow_instance_id()
					+ "' and  workflow_id = '" + approveRequest.getWorkflow_id() + "' and level_id = '"
					+ approveRequest.getLevel_id() + "' and layer_id = '" + approveRequest.getLayer_id() + "' ";

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

		return new ResponseEntity<Object>(approveRequest, HttpStatus.OK);
	}
	
	/*
	 * { "workflow_instance_id": "1", "workflow_id" : "1", "email_id" :
	 * "chinu@microsoft.com", "org_name":"Microsoft", "level_id" : "2",
	 * "layer_id" : "1"}
	 */
	@RequestMapping(value = "/rejectRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> rejectRequest(@RequestBody RejectRequest rejectRequest) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();

		Statement stmt = null;
		try {

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			rejectRequest.setDescription("Rejected by :" + rejectRequest.getEmail_id());
			rejectRequest.setStatus("Reject");
			rejectRequest.setStatus_id(helper.getStatusIDFromStatusName(rejectRequest.getStatus()));
			rejectRequest.setTimestamp();

			sql = " UPDATE workflowinstance SET timestamp = '" + rejectRequest.getTimestamp() + "' , status_id='"
					+ rejectRequest.getStatus_id() + "' , description = '" + rejectRequest.getDescription()
					+ "' WHERE workflow_instance_id = '" + rejectRequest.getWorkflow_instance_id()
					+ "' and  workflow_id = '" + rejectRequest.getWorkflow_id() + "' and level_id = '"
					+ rejectRequest.getLevel_id() + "' and layer_id = '" + rejectRequest.getLayer_id() + "' ";

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

		return new ResponseEntity<Object>(rejectRequest, HttpStatus.OK);
	}
	
	

	/*
	 * {"org_name": "Microsoft"}
	 */
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getAllDepartments(@RequestBody AllDepartments allDepartments) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;

		allDepartments.setOrg_id(helper.getOrgIDFromOrgName(allDepartments.getOrg_name()));

		List<HashMap<String, Object>> res_department_list = new ArrayList<HashMap<String, Object>>();

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT workflow.department.dept_id , workflow.department.name, workflow.user.email_id as admin FROM workflow.department join workflow.user on workflow.department.dept_id= workflow.user.dept_id  where workflow.department.org_id = '"
					+ allDepartments.getOrg_id() + "' and workflow.user.role_id = 1";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);

			while (rs.next()) {

				HashMap<String, Object> department_data = new HashMap<String, Object>();

				int department_id = rs.getInt("dept_id");
				String department_name = rs.getString("name");
				String admin = rs.getString("admin");

				department_data.put("department_id", department_id);
				department_data.put("department_name", department_name);
				department_data.put("admin", admin);

				res_department_list.add(department_data);

			}

			System.out.println("All departments : " + res_department_list);

			allDepartments.setDepartment_list(res_department_list);

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

		return new ResponseEntity<Object>(allDepartments, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllOrganizations", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getAllOrganizations(@RequestBody AllOrganizations allOrganizations) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;

		// get all approvers of next level
		List<String> organization_list = new ArrayList<String>();

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name from organization";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);

			while (rs.next()) {

				String organization = rs.getString("name");
				organization_list.add(organization);

			}

			System.out.println("All organizations : " + organization_list);

			allOrganizations.setOrganization_list(organization_list);

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

		return new ResponseEntity<Object>(allOrganizations, HttpStatus.OK);
	}

	/*
	 * {"org_name": "Microsoft", "dept_name": "Software"}
	 */
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getAllUsers(@RequestBody AllUsers allUsers) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;

		allUsers.setOrg_id(helper.getOrgIDFromOrgName(allUsers.getOrg_name()));
		allUsers.setDept_id(helper.getDeptIDFromDeptName(allUsers.getDept_name()));

		// get all approvers of next level
		List<String> user_list = new ArrayList<String>();

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT email_id from user where org_id = '" + allUsers.getOrg_id() + "' and dept_id = '"
					+ allUsers.getDept_id() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);

			while (rs.next()) {

				String user = rs.getString("email_id");
				user_list.add(user);

			}

			System.out.println("All users : " + user_list);

			allUsers.setUsers(user_list);

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

		return new ResponseEntity<Object>(allUsers, HttpStatus.OK);
	}

	/*
	 * {"org_name": "Microsoft"}
	 */
	@RequestMapping(value = "/getAllUnassignedDepartments", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> getAllDepartments(@RequestBody AllUnassignedDepartments allUnassignedDepartments) {

		Helper helper = new Helper();
		DBConnection dbCon = new DBConnection();
		Connection conn = dbCon.getConnection();
		Statement stmt = null;

		allUnassignedDepartments.setOrg_id(helper.getOrgIDFromOrgName(allUnassignedDepartments.getOrg_name()));

		List<String> department_list = new ArrayList<String>();

		try {

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT workflow.department.name as dept_name FROM workflow.department left join workflow.user on workflow.department.dept_id= workflow.user.dept_id where workflow.department.org_id = '"
					+ allUnassignedDepartments.getOrg_id() + "' and workflow.user.email_id is null";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);

			while (rs.next()) {

				String department_name = rs.getString("dept_name");

				department_list.add(department_name);

			}

			System.out.println("All departments : " + department_list);

			allUnassignedDepartments.setDepartment_list(department_list);

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

		return new ResponseEntity<Object>(allUnassignedDepartments, HttpStatus.OK);
	}

	// ==========================================================

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> test(@RequestBody Test test) {

		return new ResponseEntity<Object>(test, HttpStatus.OK);
	}

}
