package com.niit.project2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="c_Forum")
//@SequenceGenerator(name="forumidseq",sequenceName="forumid_seq")
public class Forum {

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumidseq")
	private int forumid;
	private String forumname;
	private String forumcontent;
	private Date createdate;
	private int forumlikes;
	private String email;
	private String forumstatus;
	
	
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumcontent() {
		return forumcontent;
	}
	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getForumlikes() {
		return forumlikes;
	}
	public void setForumlikes(int forumlikes) {
		this.forumlikes = forumlikes;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getForumstatus() {
		return forumstatus;
	}
	public void setForumstatus(String forumstatus) {
		this.forumstatus = forumstatus;
	}
	
	
	
}
