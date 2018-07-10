package com.niit.project2.dao;

import java.util.List;

import com.niit.project2.model.User;

public interface UserDao
{
	public boolean saveUser(User user);         //for registration
	public boolean updateUser(User user);       //update user details
    public boolean deleteUser(String email);    //see/fetch/get the details through email to delete
    public User getUser(String email);          //admin may fetch all the user details with ths email
    public List<User> userList();				//will diplay the list of all users
    public User validateUser(String email,String password);    //login - validation
	
	
	}
