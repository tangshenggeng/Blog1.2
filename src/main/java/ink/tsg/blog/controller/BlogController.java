package ink.tsg.blog.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ink.tsg.blog.bean.Blog;
import ink.tsg.blog.bean.BlogExample;
import ink.tsg.blog.bean.BlogExample.Criteria;
import ink.tsg.blog.service.BlogService;
import ink.tsg.utlis.Msg;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	//==============前台功能==================
	/**
	 * 查询博客总数量
	 * */
	@RequestMapping(value="/count_blogs",method=RequestMethod.GET)
	@ResponseBody
	public Msg getCountOfBlogs() {
		Long count = blogService.getCountOfBlogs();
		return Msg.success().add("num_blogs", count);
	}
	/**
	 * 通过Id查询博客，阅读全文
	 * */
	@RequestMapping(value="/readBlog/{blogId}",method=RequestMethod.GET)
	public String getBlogById(@PathVariable("blogId")Integer id,Model model) {
		BlogExample blogExample = new BlogExample();
		Criteria criteria = blogExample.createCriteria();
		criteria.andBlogIdEqualTo(id);
		Blog blog = blogService.findBlogById(blogExample);
		model.addAttribute("getBlogById", blog);
		return "forward:/BFReception/html/reading.jsp";
	}
	/**
	  * 查询博客
	 * */
	@RequestMapping(value="/getNewBlogs/{blogTcId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getNewBlogs(@PathVariable("blogTcId") Integer blogTcId,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		// 设置开始分页的信息
		BlogExample blogExample = new BlogExample();
		//根据id倒序
		blogExample.setOrderByClause("blog_id DESC");
		//如果外键是0则查询所有文章，非0则给条件添加外键值
		if(blogTcId == 0) {
			Criteria criteria = blogExample.createCriteria();
			criteria.andBlogIdNotEqualTo(blogTcId);
			//第一个参数是条件，第二个是页码，第三个是查询多少文章
			PageInfo<Blog> page = getAllBlogWhitPage(blogExample,pn,8);
			return Msg.success().add("newBlogs", page);
		}else {
			Criteria criteria = blogExample.createCriteria();
			criteria.andBlogTcIdEqualTo(blogTcId);
			PageInfo<Blog> page = getAllBlogWhitPage(blogExample,pn,5);
			return Msg.success().add("newBlogsWhitFk", page);
		}
	}
	
	//===============提取的方法====================
	public PageInfo<Blog> getAllBlogWhitPage(BlogExample blogExample,Integer pn,Integer blogsNum){
		//每次查询blogNums篇文章
		PageHelper.startPage(pn, blogsNum);
		List<Blog> blogs = blogService.getBlogByfk(blogExample);
		//连续显示5个页码
		PageInfo<Blog> page = new PageInfo<Blog>(blogs,2);
		return page;
	}
	
	
	//提取方法，查询所有博客(联合查询三级分类)
	//分页管理blogExample为自定义的查询条件，pn自定义的页码 blogNums每次查询多少文章
	public PageInfo<Blog> getAllBlogWhitTC(BlogExample blogExample,Integer pn){
		//每次查询5篇文章
		PageHelper.startPage(pn, 5);
		List<Blog> blogs = blogService.findAllBlog(blogExample);
		//连续显示5个页码
		PageInfo<Blog> page = new PageInfo<Blog>(blogs,5);
		return page;
	}
	
	//=============后台功能==============
	/**
	 * 删除博客
	 * */
	@RequestMapping(value="/delBlogById/{blogId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delBlogById(@PathVariable("blogId") Integer id) {
		blogService.delBlogById(id);
		return Msg.success().add("success","删除成功！");
	}
	/**
	  *  更新博客内容
	 * */
	@RequestMapping(value="/editBlog/{blogId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg editSC(@PathVariable("blogId")Integer blogId,@Valid Blog blog,BindingResult result) {
		if(result.hasErrors()) {
			//创建一个map，把错误信息添加到map中
			Map<String,Object> map = new HashMap<>();
			//校验失败的错误信息
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				return Msg.fail().add("errors", map);
			}else {
				blogService.editBlog(blog);
				return Msg.success();
			}
	}
	/**
	 * 分类筛选
	 * */
	@RequestMapping(value="getByFK")
	@ResponseBody
	public Msg getBlogByFK(@RequestParam(value = "pn", defaultValue = "1")Integer pn,@RequestParam(value = "blogTcId")Integer blogTcId) {
		// 设置开始分页的信息
		BlogExample blogExample = new BlogExample();
		//根据id倒序
		blogExample.setOrderByClause("blog_id DESC");
		Criteria criteria = blogExample.createCriteria();
		criteria.andBlogTcIdEqualTo(blogTcId);
		PageInfo<Blog> page = getAllBlogWhitTC(blogExample,pn);
		return Msg.success().add("pageInfo", page);
		
	}
	
	/**
	 * 查询所有博客
	 * */
	@RequestMapping(value="/getAllBlogs",method=RequestMethod.GET)
	@ResponseBody
	public Msg getAllBlogs(@RequestParam(value = "pn", defaultValue = "1")Integer pn) {
		BlogExample blogExample = new BlogExample();
		//根据id倒序
		blogExample.setOrderByClause("blog_id DESC");
		// 使用pageInfo包装查询后的结果,第二个参数是要连续显示的页码数
		PageInfo<Blog> page = getAllBlogWhitTC(blogExample,pn);
		return Msg.success().add("pageInfo", page);
	}
	
	
	/**
	  * 通过id查询博客信息
	 * */
	@RequestMapping(value="/reEditBlog/{blogId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBlogInfoById(@PathVariable Integer blogId) {
		Blog blog = blogService.getBlogInfoById(blogId);
		return Msg.success().add("blog", blog);
	}
	/**
	 * 编写博客并上传
	 * */
	@RequestMapping(value="/addNewBlog",method=RequestMethod.POST)
	@ResponseBody
	public Msg addNewBlog(@Valid Blog blog,BindingResult result) {
		if(result.hasErrors()) {
			//创建一个map，把错误信息添加到map中
			Map<String,Object> map = new HashMap<>();
			//校验失败的错误信息
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				return Msg.fail().add("errors", map);
			}else {
				java.util.Date curDate = new java.util.Date();//新建一个util类型的date
		        java.sql.Date date = new java.sql.Date(curDate.getTime());//进行日期的转换		
				blog.setBlogUptime(date);
				blogService.addNewBlog(blog);
				return Msg.success();
			}
	}
	
	/**
	  *  关键字模糊搜索
	 * */
	@RequestMapping(value="/getByKeyWord/{blogArticle}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getByKeyWord(@PathVariable("blogArticle")String keyWord) {
		BlogExample blogExample = new BlogExample();
		//设置为根据文章id倒序
		blogExample.setOrderByClause("blog_id DESC");
		Criteria criteria = blogExample.createCriteria();
		if(keyWord.isEmpty()||keyWord.trim().length()==0) {
			return Msg.fail().add("error", "请输入关键字后查找!");
		}else {
			//关键字的模糊搜索
			criteria.andBlogArticleLike("%"+keyWord+"%");
			List<Blog> blogs = blogService.getByKeyWord(blogExample);
			return Msg.success().add("blogs_keyword", blogs);
		}
	}
	/**
	 * 通过外键查询博客
	 * */
	@RequestMapping(value="/getBlogByfk/{blogTcId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBlogByfk(@PathVariable("blogTcId")Integer blogTcId,@RequestParam(value = "pn", defaultValue = "1")Integer pn) {
		// 设置开始分页的信息
		PageHelper.startPage(pn, 2);
		BlogExample blogExample = new BlogExample();
		//设置为根据文章id倒序
		blogExample.setOrderByClause("blog_id DESC");
		Criteria criteria = blogExample.createCriteria();
		criteria.andBlogTcIdEqualTo(blogTcId);
		List<Blog> blogs = blogService.getBlogByfk(blogExample);
		PageInfo<Blog> page = new PageInfo<Blog>(blogs, 5);
		return Msg.success().add("pageInfo", page);
	}
	
}

