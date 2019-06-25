package ink.tsg.intoAdmin.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ink.tsg.intoAdmin.bean.AdminUser;
import ink.tsg.intoAdmin.bean.AdminUserExample;
import ink.tsg.intoAdmin.bean.AdminUserExample.Criteria;
import ink.tsg.intoAdmin.service.AdminService;
import ink.tsg.utlis.Msg;
/**
 * 管理员登录控制层
 * */
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 校验登录信息
	 * */
	@RequestMapping(value="/validata",method=RequestMethod.POST)
	@ResponseBody
	public Msg validata(AdminUser adminUser) {
			Map<String,Object> map = new HashMap<>();
			//校验用户名是否存在
			Long userCount = getUserCount(adminUser.getUserName());
			if(userCount == 0) {
				map.put("validate_user","用户不存在");
				return Msg.fail().add("validate",map);
			}
			//验证密码是否正确
			AdminUser ofUser = getPwdOfUser(adminUser.getUserName());
			if(!ofUser.getUserPwd().equals(adminUser.getUserPwd())) {
				map.put("validate_pwd","密码错误");
				return Msg.fail().add("validate",map);
			}
			//把正确的用户名和密码保存传递过去
			return Msg.success().add("success_name", adminUser.getUserName()).add("success_pwd", adminUser.getUserPwd());
		}

	/**
	 * 得到用户名的密码进行校验
	 * */
	public AdminUser getPwdOfUser(String userName) {
		AdminUserExample example = new AdminUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		return adminService.getPwdOfUser(example);
	}
	
	/**
	 * 通过用户名查询是否存在用户
	 * */
	public Long getUserCount(String userName) {
		AdminUserExample example = new AdminUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		return adminService.getUserCount(example);
	}
	/**
	 *登录功能
	 * */
	@RequestMapping(value="/loginInto/{userName}/{userPwd}",method=RequestMethod.GET)
	public String loginInto(@PathVariable("userName")String userName,@PathVariable("userPwd")String userPwd) {
		//校验用户名是否存在
		Long userCount = getUserCount(userName);
		if(userCount == 0) {
			return "redirect:/ADLogin/error.jsp";
		}
		//验证密码是否正确
		AdminUser ofUser = getPwdOfUser(userName);
		if(!userPwd.equals(ofUser.getUserPwd())) {
			return "redirect:/ADLogin/error.jsp";
		}
		if(ofUser.getUserId() == 1) {
			return "LJ-CST-admin/cst_main";
		}else {
			return "Blog-admin/main";
		}
		
	}
}
