package model;

import java.util.List;
import java.util.Map;

public class NextWorkers {
	
	private int workflow_instance_id;
	private List<Map<String, Object>> workers;
	private int current_level_id;
	private int workflow_id;
	private int new_level_id;
	
	public int getNew_level_id() {
		return new_level_id;
	}
	public void setNew_level_id(int new_level_id) {
		this.new_level_id = new_level_id;
	}
	public int getWorkflow_id() {
		return workflow_id;
	}
	public void setWorkflow_id(int workflow_id) {
		this.workflow_id = workflow_id;
	}
	public int getCurrent_level_id() {
		return current_level_id;
	}
	public void setCurrent_level_id(int current_level_id) {
		this.current_level_id = current_level_id;
	}
	public int getWorkflow_instance_id() {
		return workflow_instance_id;
	}
	public void setWorkflow_instance_id(int workflow_instance_id) {
		this.workflow_instance_id = workflow_instance_id;
	}
	public List<Map<String, Object>> getWorkers() {
		return workers;
	}
	public void setWorkers(List<Map<String, Object>> workers) {
		this.workers = workers;
	}
	
	

}
