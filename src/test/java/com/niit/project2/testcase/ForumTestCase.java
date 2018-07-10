package com.niit.project2.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.dao.ForumDao;
import com.niit.project2.model.Forum;


public class ForumTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Forum forum;
	
	@Autowired
	private static ForumDao forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	forum=(Forum) context.getBean("forum");
	forumDAO=(ForumDao) context.getBean("forumDAO");
	
	}
	
	@Test
	public void forumAddTest()
	{
		forum.setForumname("JAVA");
		forum.setForumcontent("specific to hibernate");
		forum.setEmail("sunanda@gmail.com");
		
		assertEquals("forum adding test case",true, forumDAO.addForum(forum));
	}


}
