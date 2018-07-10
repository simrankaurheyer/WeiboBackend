package com.niit.project2.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project2.dao.ProfileDao;
import com.niit.project2.model.Profile;

@Transactional
@Repository("profileDAO")
public class ProfileDaoImpl implements ProfileDao
{
	@Autowired
	SessionFactory session;

	public boolean uploadProfile(Profile profile) {
		try {
			session.getCurrentSession().saveOrUpdate(profile);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public Profile getProfileDetails(String loginname) {
		
		return (Profile)session.getCurrentSession().get(Profile.class, loginname);
	}

}
