package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDao {
	public boolean addBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public Blog getBlog(int blogId);

	public boolean approveBlog(Blog blog);

	public boolean rejectBlog(Blog blog);

	public List<Blog> listBlog(String username);

}
