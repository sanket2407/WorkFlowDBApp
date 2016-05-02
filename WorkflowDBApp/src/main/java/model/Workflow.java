package model;

public class Workflow {

	private String email_id = "";
	private String request_type_name  = "";
	private int request_type_id;
	private String org_name = "";
	private int org_id;
	private String description = "";
	private String department_name = "";
	private int dept_id;
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getRequest_type_name() {
		return request_type_name;
	}
	public void setRequest_type_name(String request_type_name) {
		this.request_type_name = request_type_name;
	}
	public int getRequest_type_id() {
		return request_type_id;
	}
	public void setRequest_type_id(int request_type_id) {
		this.request_type_id = request_type_id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	
	
}
