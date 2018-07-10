package com.niit.project2.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.dao.ProfileDao;
import com.niit.project2.model.Profile;

public class ProfileTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Profile profile;
	
	@Autowired
	private static ProfileDao profileDAO;
	
	@BeforeClass
	public static void initialize()
	{
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	profile=(Profile) context.getBean("profile");
	profileDAO=(ProfileDao) context.getBean("profileDAO");
	
	}
	
	@Test
	public void getProfile()
	{
		Profile p = profileDAO.getProfileDetails("sun@gmail.com");
		
		System.out.println("name: "+p.getLoginname());
		assertNotNull(p);
	}


}