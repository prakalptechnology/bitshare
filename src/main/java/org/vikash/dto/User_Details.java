package org.vikash.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Details {
	@Id
	private long user_id ;
	private int College_id ;
	private int company_id ;
	private int user_type ;
	private String designation ;
	private int location_id ;
	private int year_of_Admission ;
	private int year_of_passing ;
	private String Address ;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getCollege_id() {
		return College_id;
	}
	public void setCollege_id(int college_id) {
		College_id = college_id;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getYear_of_Admission() {
		return year_of_Admission;
	}
	public void setYear_of_Admission(int year_of_Admission) {
		this.year_of_Admission = year_of_Admission;
	}
	public int getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(int year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
}
