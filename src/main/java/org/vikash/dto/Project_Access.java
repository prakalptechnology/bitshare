package org.vikash.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project_Access {
	@Id
	private long access_id ;
	private long user_id ;
	private String username ;
	private int access_type ;
	private long project_id ;
	public long getAccess_id() {
		return access_id;
	}
	public void setAccess_id(long access_id) {
		this.access_id = access_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccess_type() {
		return access_type;
	}
	public void setAccess_type(int access_type) {
		this.access_type = access_type;
	}
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
}
