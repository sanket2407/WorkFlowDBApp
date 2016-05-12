package model;

import java.util.List;

public class AllDepartments1 {
	
	private String org_name = "";
	private int org_id;
	private List<String> dept_list;
	
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
	public List<String> getDept_list() {
		return dept_list;
	}
	public void setDept_list(List<String> dept_list) {
		this.dept_list = dept_list;
	}
	

}
