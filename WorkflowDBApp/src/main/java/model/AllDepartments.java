package model;

import java.util.HashMap;
import java.util.List;

public class AllDepartments {

	private String org_name = "";
	private int org_id;
	private List<HashMap<String,Object>> department_list;
	
	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public List<HashMap<String,Object>> getDepartment_list() {
		return department_list;
	}

	public void setDepartment_list(List<HashMap<String,Object>> department_list) {
		this.department_list = department_list;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

}
