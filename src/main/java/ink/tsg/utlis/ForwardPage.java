package ink.tsg.utlis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  本类用于页面的跳转
 * */
@Controller
public class ForwardPage {
	/**
	 * 跳转到一级分类页面
	 * */
	@RequestMapping("/toManageFirstClass")
	public String toManageClass() {
		return "Blog-admin/manageFirstClass";
	}
	/**
	 * 跳转到主界面
	 * */
	@RequestMapping("/toMain")
	public String toMain() {
		return "Blog-admin/main";
	}
	/**
	 * 跳转到二级分类页面
	 * */
	@RequestMapping("/toManageSecondClass")
	public String toManageSecondClass() {
		return "Blog-admin/manageSecondClass";
	}
	/**
	 * 跳转到三级分类页面
	 * */
	@RequestMapping("/toManageThirdClass")
	public String toManageThirdClass() {
		return "Blog-admin/manageThirdClass";
	}
	/**
	 * 跳转到博客管理页面
	 * */
	@RequestMapping("/toManageBlog")
	public String toManageBlog() {
		return "Blog-admin/manageBlog";
	}
	/**
	 * 跳转到写博客页面
	 * */
	@RequestMapping("/toWriteBlog")
	public String toWriteBlog() {
		return "Blog-admin/writeBlog";
	}
	
	
	/**
	 * ===========前台页面的跳转=============
	 * 
	 * */
	@RequestMapping("toHome")
	public String toHome() {
		return "forward:/BFReception/html/welcome.jsp";
	}
	@RequestMapping("toStudyNote")
	public String toStudyNote() {
		return "forward:/BFReception/html/studyNote.jsp";
	}
	@RequestMapping("toDreamNote")
	public String toDreamNote() {
		return "forward:/BFReception/html/dreamNote.jsp";
	}
	@RequestMapping("toAboutMe")
	public String toAboutMe() {
		return "forward:/BFReception/html/about.jsp";
	}
	
}
