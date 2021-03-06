package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ApproveRequest {
	
	private int workflow_instance_id;
	private int workflow_id;
	private String email_id;
	private String org_name;
	private int level_id;
	private int layer_id;
	private String description;
	private String status;
	private int status_id;
	private String timestamp = "";
	
	public int getWorkflow_instance_id() {
		return workflow_instance_id;
	}
	public void setWorkflow_instance_id(int workflow_instance_id) {
		this.workflow_instance_id = workflow_instance_id;
	}
	public int getWorkflow_id() {
		return workflow_id;
	}
	public void setWorkflow_id(int workflow_id) {
		this.workflow_id = workflow_id;
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
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public int getLayer_id() {
		return layer_id;
	}
	public void setLayer_id(int layer_id) {
		this.layer_id = layer_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		df.setTimeZone(tz);
		this.timestamp =  df.format(new Date());
	}

}
