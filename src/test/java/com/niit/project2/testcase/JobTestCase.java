package com.niit.project2.testcase;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.dao.JobDao;
import com.niit.project2.model.Job;
import com.niit.project2.model.JobApplication;




public class JobTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Job job;
	
	@Autowired
	private static JobDao jobDAO;
	
	@Autowired
	private static JobApplication jobApplication;
	
	@BeforeClass
	public static void initialize()
	{
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	job=(Job) context.getBean("job");
	jobDAO=(JobDao) context.getBean("jobDAO");
	jobApplication=(JobApplication) context.getBean("jobApplication");
	
	}
	
	@Test
	public void jobAddTest()
	{
		job.setJobqualification("MCA");
		job.setJobdescription("Software developing using java");
		job.setJobsalary(1200000);
		job.setJobtitle("Software developer");
		job.setNo_of_openings(3);
		
		assertEquals("job adding test case",true, jobDAO.saveJob(job));
	}
	
	@Test
	public void jobApplicationAddTest()
	{
		jobApplication.setEmail("sunnu@gmail.com");
		jobApplication.setJobid(103);
		
		assertEquals("job application adding test case", true, jobDAO.saveJobApplication(jobApplication));
	}

}
