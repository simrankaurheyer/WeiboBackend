package com.niit.project2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
//@SequenceGenerator(name="blogidseq",sequenceName="blog_seq")
@Table(name="c_blog")
public class Blog  extends BaseDomain implements Serializable{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogidseq")
	private int blogid;
	private String blogname;
	private String blogcontent;
	private String email;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date blogcreatedDate;
	private String blogstatus;
	private int bloglikes;
	
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBlogcreatedDate() {
		return blogcreatedDate;
	}
	public void setBlogcreatedDate(Date blogcreatedDate) {
		this.blogcreatedDate = blogcreatedDate;
	}
	public String getBlogstatus() {
		return blogstatus;
	}
	public void setBlogstatus(String blogstatus) {
		this.blogstatus = blogstatus;
	}
	public int getBloglikes() {
		return bloglikes;
	}
	public void setBloglikes(int bloglikes) {
		this.bloglikes = bloglikes;
	}

}
