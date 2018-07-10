package com.niit.project2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="c_job_application")
public class JobApplication extends BaseDomain implements Serializable {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int jobapplicationid ;
	private String email;
	private int jobid;
	
	public String getJobapplicationreason() {
		return jobapplicationreason;
	}
	public void setJobapplicationreason(String jobapplicationreason) {
		this.jobapplicationreason = jobapplicationreason;
	}
	private Date applied_date;
	private String jobapplicationreason;
	private char jobapplicationstatus ;  //N->New Application
						                 //R->Reject
					       				 //C->Call for interview
						   				 //S -> Selected
	
	
	
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getJobapplicationid() {
		return jobapplicationid;
	}
	public void setJobapplicationid(int jobapplicationid) {
		this.jobapplicationid = jobapplicationid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Date applied_date) {
		this.applied_date = applied_date;
	}
	public char getJobapplicationstatus() {
		return jobapplicationstatus;
	}
	public void setJobapplicationstatus(char jobapplicationstatus) {
		this.jobapplicationstatus = jobapplicationstatus;
	}
	public String getJobApplicationReason() {
		return jobapplicationreason;
	}
	public void setJobApplicationReason(String reason) {
		this.jobapplicationreason = reason;
	}
	
	
	
	
	
}