package model;

public class RequestType {

	private String email_id = ""; 
	private String request_type_name = ""; 
	private String org_name = "";
	private int org_id;
	
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
