package model;

import java.util.List;
import java.util.Map;

public class GetAllAssignedAndPendingRequests {
	
	private String email_id = "";
	private String org_name = "";
	private int org_id;
	private List<Map<String, Object>> assigned_or_pending_req_list;
	
	public List<Map<String, Object>> getAssigned_or_pending_req_list() {
		return assigned_or_pending_req_list;
	}
	public void setAssigned_or_pending_req_list(List<Map<String, Object>> assigned_or_pending_req_list) {
		this.assigned_or_pending_req_list = assigned_or_pending_req_list;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
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
	
	

}
