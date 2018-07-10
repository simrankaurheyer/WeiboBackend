package com.niit.project2.dao;

import java.util.List;

import com.niit.project2.model.Job;
import com.niit.project2.model.JobApplication;

public interface JobDao
{
	public boolean saveJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobid);
	public List<Job> jobList();
	public List<Job> jobList(char jobstatus);
	public boolean isJobOpened(int jobid);
	public boolean deletejob(int jobid);
	
	//for applying to the particular job
	
	public boolean saveJobApplication(JobApplication jobApplication);
	public boolean update(JobApplication jobApplication); // if admin needs to change the status of jobapplication (accept/reject/call for interview)
	public List<JobApplication> list(int jobid);	// for fetching list of total jobapplications for a particular job based on job id  by user
	public List<JobApplication> list(int jobid, char jobstatus);
	
	
	// public  boolean isJobAlreadyApplied(String email, int jobid);   //user applied for job so user cannot be deleted
	     					//changed to below function
	public boolean isAlreadyApplied(String email, int jobid); //if job is aleady applied it wil return the job application else will return null
	public List<JobApplication> userAppliedJobList(String email);
	public Job getjobstatus(int jobid,char jobstatus); // admin/user wants to know whether the job existed with particular status or not   
	public boolean approveApplication(int jobapplicationid);
	public boolean rejectApplication(int jobapplicationid);
	public JobApplication getApplication(int jobapplicationid);
	public List<JobApplication> listapp();
}
