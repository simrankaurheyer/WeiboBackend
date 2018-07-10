package com.niit.project2.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project2.dao.ForumDao;
import com.niit.project2.model.Forum;

@Transactional
@Repository("forumDAO")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private Forum forum;

	@Autowired
	private ForumDao forumDAO;

	private int getMaxForumID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(forumid) from Forum")
					.uniqueResult();
		} catch (Exception e) {

			e.printStackTrace();
			return 100;
		}

		return maxValue;
	}

	public boolean addForum(Forum forum) {
		try {
			forum.setForumid(getMaxForumID() + 1);
			forum.setCreatedate(new Date());
			forum.setForumstatus("N");
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteForum(int forumid) {
		try {
			sessionFactory.getCurrentSession().delete(getForum(forumid));
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public List<Forum> ForumList() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	public List<Forum> approvedListForum() {
		return sessionFactory.getCurrentSession().createQuery("from Forum Where status='A'").list();

	}

	public boolean approveForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumstatus("A"); // specifying the status of the blog as 'A' which means approved
			sessionFactory.getCurrentSession().update(forum); // then again updating the blog
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumstatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public Forum getForum(int forumid) {
		return sessionFactory.getCurrentSession().get(Forum.class, forumid);
	}

	public boolean incrementLikes(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumlikes(forum.getForumlikes() + 1);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

}
