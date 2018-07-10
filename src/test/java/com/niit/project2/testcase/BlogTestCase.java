package com.niit.project2.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.dao.BlogDao;
import com.niit.project2.model.Blog;


public class BlogTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Blog blog;
	
	@Autowired
	private static BlogDao blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	blog=(Blog) context.getBean("blog");
	blogDAO=(BlogDao) context.getBean("blogDAO");
	
	}
	
	@Test
	public void blogAddTest()
	{
		blog.setBlogname("JAVA");
		blog.setBlogcontent("specific to hibernate");
		blog.setEmail("sunanda@gmail.com");
		
		assertEquals("blog adding test case",true, blogDAO.insertBlog(blog));
	}


}
