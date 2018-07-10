package com.niit.project2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "c_friend")
public class Friend extends BaseDomain implements Serializable
{
	@Id
	private int friendid;
	private String loginname;
	private String friendname;
	private String friendstatus;
	
	
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public String getFriendstatus() {
		return friendstatus;
	}
	public void setFriendstatus(String friendstatus) {
		this.friendstatus = friendstatus;
	}
	
	
	
	
	
}
