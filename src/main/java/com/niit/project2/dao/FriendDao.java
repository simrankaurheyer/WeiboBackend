package com.niit.project2.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.project2.model.Friend;
import com.niit.project2.model.User;


@Component
public interface FriendDao
{
	public List<Friend> friendList(String loginname);
	public List<Friend> pendingFriendRequestList(String loginname);
	public List<User> suggestedPeopleList(String loginname);

	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendid);
	public boolean deleteFriendRequest(int friendid);
	public Friend getFriend(int friendid);

}

