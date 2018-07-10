package com.niit.project2.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.dao.BlogDao;
import com.niit.project2.model.Blog;
import com.niit.project2.model.BlogComment;

@Transactional
@Repository("blogDAO")
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private BlogDao blogDAO;

	@Autowired
	private Blog blog;
	
	private int getMaxBlogID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(blogid) from Blog").uniqueResult();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 100;
		}

		return maxValue;
	}
	
	

	public boolean insertBlog(Blog blog) {
		try {
			blog.setBlogid(getMaxBlogID() + 1);
			blog.setBlogcreatedDate(new Date());
			blog.setBlogstatus("N");
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlog(int blogid) {
		try {
			sessionFactory.getCurrentSession().delete(getBlog(blogid));
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlog(int blogid) {

		return sessionFactory.getCurrentSession().get(Blog.class, blogid);
	}

	public List<Blog> approvedblogList() {

		return sessionFactory.getCurrentSession().createQuery("from Blog Where status='A'").list();
	}

	public List<Blog> blogList() {

		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	public boolean approveBlog(int blogid) { // how to approve a particular blog

		try {
			Blog blog=getBlog(blogid);
			blog.setBlogstatus("A"); // specifying the status of the blog as 'A' which means approved
			sessionFactory.getCurrentSession().update(blog); // then again updating the blog
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean rejectBlog(int blogid) {

		try {
			Blog blog=getBlog(blogid);
			blog.setBlogstatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean incrementLikes(int blogid) {
		try {
		Blog blog=getBlog(blogid);
		blog.setBloglikes(blog.getBloglikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
	} catch (HibernateException e) {

		e.printStackTrace();
		return false;
	}
}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

/*---------------blog comment-------------------------------*/
	
	
	
	private int getMaxBlogCommentID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(blogcommentid) from BlogComment").uniqueResult();
			} catch (Exception e) {
				
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}
	
	public boolean saveBlogComment(BlogComment blogComment) {
		try {
			blogComment.setBlogcommentid(getMaxBlogCommentID() + 1);
			blogComment.setCommentedDate(new Date());
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	

	public boolean deleteBlogComment(int blogcommentid) {
		
		try {
			sessionFactory.getCurrentSession().delete(getBlogComment(blogcommentid));
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().update(blogComment);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public BlogComment getBlogComment(int blogcommentid) {
		
	return	sessionFactory.getCurrentSession().get(BlogComment.class, blogcommentid);
	}

	public List<BlogComment> blogCommentList(int blogid) {
		return sessionFactory.getCurrentSession().createCriteria(BlogComment.class).add(Restrictions.eq("blogid", blogid)).list();
	}



	
	
	
}
