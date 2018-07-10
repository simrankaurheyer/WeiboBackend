package com.niit.project2.dao;

import java.util.List;

import com.niit.project2.model.Blog;
import com.niit.project2.model.BlogComment;

public interface BlogDao{

	public boolean insertBlog(Blog blog);
	
	
	
	

	public boolean deleteBlog(int blogid);

	public boolean updateBlog(Blog blog);

	public boolean approveBlog(int blogid);

	public boolean rejectBlog(int blogid);

	public boolean incrementLikes(int blogid);

	public Blog getBlog(int blogid);

	public List<Blog> approvedblogList();

	public List<Blog> blogList();
	
	/*blog comment
	*/
	public BlogComment getBlogComment(int blogcommentid);
	public List<BlogComment> blogCommentList(int blogid);
	public boolean saveBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(int blogcommentid);
	public boolean updateBlogComment(BlogComment blogComment);
	
	

	// adming can accept/reject the blog.
	// we can use update(Blog blog) method.
	// comment on a particular blog.
	// one to many -> N number of user can comment on.
	// a particular blog.

}
