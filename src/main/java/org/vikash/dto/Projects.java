package org.vikash.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Projects {
	@Id
	private long project_id ;
	private String project_name ;
	private String project_desc ;
	private int Sensitivity_level ;
	private int user_id ;
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_desc() {
		return project_desc;
	}
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	public int getSensitivity_level() {
		return Sensitivity_level;
	}
	public void setSensitivity_level(int sensitivity_level) {
		Sensitivity_level = sensitivity_level;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
