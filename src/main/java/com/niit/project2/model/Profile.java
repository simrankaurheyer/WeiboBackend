package com.niit.project2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "c_profile")
public class Profile 
{
	@Id
	private String loginname;

	private byte[] profilepicture;
	
	
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public byte[] getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(byte[] profilepicture) {
		this.profilepicture = profilepicture;
	}
	
	

}
