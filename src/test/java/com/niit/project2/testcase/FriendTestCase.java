package com.niit.project2.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.dao.FriendDao;
import com.niit.project2.model.Friend;

public class FriendTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Friend friend;
	
	@Autowired
	private static FriendDao friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
	context =new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	friend=(Friend) context.getBean("friend");
	friendDAO=(FriendDao) context.getBean("friendDAO");
	
	}
	
	@Test
	public void friendList()
	{
		List<Friend> friends=friendDAO.friendList("shuashi");
		boolean flag=friends.isEmpty();
		assertNotNull(friends);
		
		for(Friend f:friends)
		{
			System.out.println("Friend Name "+ f.getFriendname());
		}
	}
	
	@Test
	public void sendFriendrequest()
	{
		
		friend.setFriendname("yatendra");
		friend.setLoginname("yatendra");
		
		assertEquals("sending friend request",true,friendDAO.sendFriendRequest(friend));
	}
}
