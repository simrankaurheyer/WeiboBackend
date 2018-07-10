package com.niit.project2.daoimpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.project2.dao.UserDao;
import com.niit.project2.model.User;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveUser(User user) {
		try {
			
				if(user.getRole()==null || user.getRole()==' ')
				{
					user.setRole('S');
				}
				
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) {
		return false;
	}
		
	}

	public boolean deleteUser(String loginname) {
		try {
			sessionFactory.getCurrentSession().delete(getUser(loginname));
			return true;
		}
		catch(Exception e) {
		return false;
	}
		}
	

	public User getUser(String loginname) {
		return sessionFactory.getCurrentSession().get(User.class, loginname);
	}

	public List<User> userList() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User validateUser(String email, String password) {
		
		User user;
		user= (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				                                                   .add(Restrictions.eq("email",email))
				                                                   .add(Restrictions.eq("password",password)).uniqueResult();
		if(user==null)
		{
			return null;
		}
		else
			return user;
		
	}
}
