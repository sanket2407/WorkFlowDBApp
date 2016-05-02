package model;

public class Workflow {
	
	// create workflow attributes
	private String email_id = "";
	private String request_type_name  = "";
	private int request_type_id;
	private String org_name = "";
	private int org_id;
	private String description = "";
	private String department_name = "";
	private int dept_id;
	
	// create level and layer attributes
	private String worker_email_id = "";
	private String worker_org_name = "";
	private int worker_org_id;
	private String level_name = "";
	private int level_id;
	private String layer_name = "";
	private int layer_id;
	private int workflow_id;
	
	
	public int getWorker_org_id() {
		return worker_org_id;
	}
	public void setWorker_org_id(int worker_org_id) {
		this.worker_org_id = worker_org_id;
	}
	public String getWorker_email_id() {
		return worker_email_id;
	}
	public void setWorker_email_id(String worker_email_id) {
		this.worker_email_id = worker_email_id;
	}
	public String getWorker_org_name() {
		return worker_org_name;
	}
	public void setWorker_org_name(String worker_org_name) {
		this.worker_org_name = worker_org_name;
	}
	public int getWorkflow_id() {
		return workflow_id;
	}
	public void setWorkflow_id(int workflow_id) {
		this.workflow_id = workflow_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLayer_name() {
		return layer_name;
	}
	public void setLayer_name(String layer_name) {
		this.layer_name = layer_name;
	}
	public int getLayer_id() {
		return layer_id;
	}
	public void setLayer_id(int layer_id) {
		this.layer_id = layer_id;
	}

	
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
