package model;

public class UpdateEmail {
	
	private String current_email_id = "";
	private String new_email_id = "";
	private String org_name = "";
	private int org_id;
	
	public String getCurrent_email_id() {
		return current_email_id;
	}
	public void setCurrent_email_id(String current_email_id) {
		this.current_email_id = current_email_id;
	}
	public String getNew_email_id() {
		return new_email_id;
	}
	public void setNew_email_id(String new_email_id) {
		this.new_email_id = new_email_id;
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
