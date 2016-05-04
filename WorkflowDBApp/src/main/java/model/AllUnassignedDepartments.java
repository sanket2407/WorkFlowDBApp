package model;

import java.util.List;

public class AllUnassignedDepartments {
	
	private String org_name = "";
	private int org_id;
	private List<String> department_list;
	
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
	public List<String> getDepartment_list() {
		return department_list;
	}
	public void setDepartment_list(List<String> department_list) {
		this.department_list = department_list;
	}
	
	

}
