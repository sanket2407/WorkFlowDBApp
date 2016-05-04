package model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Request {

	private int workflow_id;
	private String email_id = "";
	private String org_name = "";
	private int org_id;
	private String description = "";
	private String level_name = "Level 0";
	private String layer_name = "Layer 0";
	private int level_id;
	private int layer_id;
	private String status_name = "";
	private int status_id;
	private int workflow_instance_id;
	private String timestamp = "";

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		df.setTimeZone(tz);
		this.timestamp =  df.format(new Date());
	}

	public int getWorkflow_instance_id() {
		return workflow_instance_id;
	}

	public void setWorkflow_instance_id(int workflow_instance_id) {
		this.workflow_instance_id = workflow_instance_id;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public String getLayer_name() {
		return layer_name;
	}

	public void setLayer_name(String layer_name) {
		this.layer_name = layer_name;
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

}
