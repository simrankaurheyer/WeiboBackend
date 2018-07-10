package com.niit.project2.dao;

import java.util.List;

import com.niit.project2.model.Forum;

public interface ForumDao
{
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(int forumid);
	public List<Forum> ForumList();
	public List<Forum> approvedListForum();
	public boolean approveForum(int forumid);
	public boolean rejectForum(int forumid);
	public Forum getForum(int forumid);
	public boolean incrementLikes(int forumid);

}
