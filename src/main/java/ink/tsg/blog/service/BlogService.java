package ink.tsg.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.blog.bean.Blog;
import ink.tsg.blog.bean.BlogExample;
import ink.tsg.blog.dao.BlogMapper;

@Service
public class BlogService {
	
	@Autowired
	private BlogMapper blogMapper;

	public void addNewBlog(Blog blog) {
		blogMapper.insertSelective(blog);
	}
	/**
	 * 内容关键字搜索
	 * */
	public List<Blog> getByKeyWord(BlogExample blogExample) {
		return blogMapper.selectByExampleWithBLOBs(blogExample);
	}
	/**
	 * 通过id查询博客
	 * */
	public Blog findBlogById(BlogExample blogExample) {
		List<Blog> list = blogMapper.selectByExampleWithBLOBs(blogExample);
		return list.get(0);
	}
	/**
	 * 通过外键查询
	 * */
	public List<Blog> getBlogByfk(BlogExample blogExample) {
		return blogMapper.selectByExampleWithBLOBs(blogExample);
	}
	/**
	 * 查询所有博客
	 * */
	public List<Blog> findAllBlog(BlogExample blogExample) {
		return blogMapper.selectByExampleWhitTC(blogExample);
	}
	public void delBlogById(Integer id) {
		blogMapper.deleteByPrimaryKey(id);
	}
	public Blog getBlogInfoById(Integer blogId) {
		return blogMapper.selectByPrimaryKey(blogId);
	}
	public void editBlog(Blog blog) {
		blogMapper.updateByPrimaryKeySelective(blog);
	}
	public Long getCountOfBlogs() {
		return blogMapper.countByExample(null);
	}
	
	
}
