package ink.tsg.intoAdmin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.intoAdmin.bean.AdminUser;
import ink.tsg.intoAdmin.bean.AdminUserExample;
import ink.tsg.intoAdmin.dao.AdminUserMapper;
/**
 * 管理员登录业务层
 * */
@Service
public class AdminService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;
	/**
	 * 验证用户是否存在
	 * */
	public Long getUserCount(AdminUserExample example) {
		return adminUserMapper.countByExample(example);
	}
	/**
	 * 得到一个管理员的信息
	 * */
	public AdminUser getPwdOfUser(AdminUserExample example) {
		return adminUserMapper.selectByExampleOfOne(example);
	}
	

	
	
}
