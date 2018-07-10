package com.niit.project2.daoimpl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.dao.FriendDao;
import com.niit.project2.dao.UserDao;
import com.niit.project2.model.Friend;
import com.niit.project2.model.User;



@Repository("friendDAO")
@Transactional
public class FriendDaoImpl implements FriendDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private Friend friend;
	
	private int getMaxFriendID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(friendid) from Friend").uniqueResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}

	public List<Friend> friendList(String loginname) {
		return sessionFactory.getCurrentSession().createQuery("from Friend where (loginname='"+loginname+"' AND friendstatus='Accepted') OR (friendname='"+loginname+"' AND friendstatus='Accepted')").list();
	}

	public List<Friend> pendingFriendRequestList(String loginname) {
		return sessionFactory.getCurrentSession().createQuery("from Friend where (loginname='"+loginname+"' AND friendstatus='Pending') OR (friendname='"+loginname+"' AND friendstatus='Pending')").list();
	}

	public List<User> suggestedPeopleList(String loginname) {
		List<String> users = sessionFactory.getCurrentSession().createSQLQuery("select loginname from c_user where loginname not in(select "
				+ "friendname from c_friend where loginname = '"+loginname+"' and friendstatus = 'Accepted' UNION ALL select loginname from c_friend "
						+ "where friendname = '"+loginname+"' and friendstatus = 'Accepted') AND loginname not in(select friendname from c_friend where "
								+ "loginname = '"+loginname+"' and friendstatus = 'Pending' UNION ALL select loginname from c_friend where friendname = '"+loginname+"'"
								+ " and friendstatus = 'Pending') and loginname!='"+loginname+"'").list();
		List<User> suggestedPeople = new ArrayList<User>();
		int i = 0;
		while(i < users.size())
		{
			User user = sessionFactory.getCurrentSession().get(User.class, users.get(i));
			suggestedPeople.add(user);
			i++;
		}
		return suggestedPeople;
	}
	
	public boolean sendFriendRequest(Friend friend) {
	try {
			friend.setFriendstatus("Pending");
			friend.setFriendid(getMaxFriendID() + 1);
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean acceptFriendRequest(int friendid) {
		try {
			Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendid);
			friend.setFriendstatus("Accepted");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteFriendRequest(int friendid) {
		try {
			Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendid);
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Friend getFriend(int friendid)
	{
		return sessionFactory.getCurrentSession().get(Friend.class, friendid);
	}
	
}
