package model;

import java.util.List;
import java.util.Map;

public class GetAllRequestsOfUser {
	
	private String email_id = "";
	private int org_id;
	private int dept_id;
	private List<Map<String, Object>> request_list;
	
	public List<Map<String, Object>> getRequest_list() {
		return request_list;
	}
	public void setRequest_list(List<Map<String, Object>> request_list) {
		this.request_list = request_list;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

}
