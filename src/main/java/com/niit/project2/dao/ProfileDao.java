package com.niit.project2.dao;

import com.niit.project2.model.Profile;

public interface ProfileDao
{
	public boolean uploadProfile(Profile profile);
	public Profile getProfileDetails(String loginname);	
/*	public Friend getFriendsProfile(String loginname);*/
}