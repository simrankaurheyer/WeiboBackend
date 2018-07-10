package com.niit.project2.daoimpl;

import java.util.Date;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.dao.JobDao;
import com.niit.project2.dao.UserDao;
import com.niit.project2.model.Job;
import com.niit.project2.model.JobApplication;

@Transactional
@Repository("jobDAO")
public class JobDaoImpl implements JobDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private JobDao jobDAO;
	
	private int getMaxJobID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(jobid) from Job").uniqueResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 100;
		}

		return maxValue;
	}
	
	public boolean saveJob(Job job) {
		try {
			job.setJobid(getMaxJobID() + 1);
			job.setPosted_date(new Date());
			job.setJobstatus('N');
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public Job getJob(int jobid) {
		return (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();
	}

	public List<Job> jobList() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	public List<Job> jobList(char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobstatus", jobstatus)).list();
	}
	
	private int getMaxJobapplicationID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(jobapplicationid) from JobApplication").uniqueResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 100;
		}
		return maxValue;
	}	
	
	public boolean isJobOpened(int jobid) {
		Job job = (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (job != null && job.getJobstatus() == 'N') {
			return true;
		}
		return false;
	}

	public boolean saveJobApplication(JobApplication jobApplication) {
		try {
				
				jobApplication.setJobapplicationid(getMaxJobapplicationID() + 1);
				jobApplication.setJobapplicationstatus('N');
				jobApplication.setApplied_date(new Date());
	
				sessionFactory.getCurrentSession().save(jobApplication);
				return true;
				
				} catch (HibernateException e) {
					
					e.printStackTrace();
					return false;
				}
	}

	public boolean update(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public List<JobApplication> list(int jobid) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("jobid", jobid)).list();
	}

	public List<JobApplication> list(int jobid, char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobstatus", jobstatus)).add(Restrictions.eq("jobid", jobid)).list();
	}

	/**
	 * This method will return jobapplication if the job already applied with this emaild.
	 * else, return false
	 */

	public boolean isAlreadyApplied(String email, int jobid) {
	JobApplication j = (JobApplication) sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("email", email))
				.add(Restrictions.eq("jobid", jobid)).uniqueResult();
	if(j == null)
	{
		return false;
	}
	else
	{
		return true;
	}
		
	}

	public List<JobApplication> userAppliedJobList(String email) {
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where email='"+email+"'").list();
	}

	public boolean deleteJob(int jobid) {
		try {
			sessionFactory.getCurrentSession().delete(getJob(jobid));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	
	//this method will return job if the job exist with this jobid and status
	public Job getjobstatus(int jobid, char jobstatus) {
		
		return (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid))
		 																		.add(Restrictions.eq("jobstatus", jobstatus)).uniqueResult();
	}

	public boolean approveApplication(int jobapplicationid) {
		JobApplication jobApplication = jobDAO.getApplication(jobapplicationid);
		
		try {
			jobApplication.setJobapplicationstatus('A');
			jobDAO.update(jobApplication);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectApplication(int jobapplicationid) {
		JobApplication jobApplication = jobDAO.getApplication(jobapplicationid);
		
		try {
			jobApplication.setJobapplicationstatus('R');
			jobDAO.update(jobApplication);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public JobApplication getApplication(int jobapplicationid) {
		return (JobApplication)sessionFactory.getCurrentSession().get(JobApplication.class, jobapplicationid);
	}

	public List<JobApplication> listapp() {
		return sessionFactory.getCurrentSession().createQuery("from JobApplication").list();
	}

	public boolean deletejob(int jobid) {
		try {
			sessionFactory.getCurrentSession().delete(getJob(jobid));
			return true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}