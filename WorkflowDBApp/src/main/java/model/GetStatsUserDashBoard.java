package model;

import java.util.List;
import java.util.Map;

public class GetStatsUserDashBoard {
	
	private String email_id = "";
	private String org_name = "";
	private int org_id;
	private int dept_id;
	private List<Map<String, Object>> user_dashboard_stats;
	
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
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
	public List<Map<String, Object>> getUser_dashboard_stats() {
		return user_dashboard_stats;
	}
	public void setUser_dashboard_stats(List<Map<String, Object>> user_dashboard_stats) {
		this.user_dashboard_stats = user_dashboard_stats;
	}
	
	
	

}
