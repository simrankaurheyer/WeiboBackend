package com.niit.project2.model;



import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name="c_job")
//@SequenceGenerator(name= "jobSequence", sequenceName="DEMO_ORD_SEQ")
public class Job extends BaseDomain implements Serializable
{

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="jobSequence")
	private int jobid;
	private String jobtitle;
	private String jobdescription;
	private String jobqualification;
	private int jobsalary;
	private char jobstatus;
	private int no_of_openings;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date posted_date;
	
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getJobqualification() {
		return jobqualification;
	}
	public void setJobqualification(String jobqualification) {
		this.jobqualification = jobqualification;
	}
	public int getJobsalary() {
		return jobsalary;
	}
	public void setJobsalary(int jobsalary) {
		this.jobsalary = jobsalary;
	}
	public char getJobstatus() {
		return jobstatus;
	}
	public void setJobstatus(char jobstatus) {
		this.jobstatus = jobstatus;
	}
	public int getNo_of_openings() {
		return no_of_openings;
	}
	public void setNo_of_openings(int no_of_openings) {
		this.no_of_openings = no_of_openings;
	}
	public Date getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}	
	
	
}