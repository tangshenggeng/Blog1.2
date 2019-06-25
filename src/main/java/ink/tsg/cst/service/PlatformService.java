package ink.tsg.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.cst.bean.Platform;
import ink.tsg.cst.dao.PlatformMapper;

/**
 * 平台业务层
 * */
@Service
public class PlatformService {
	
	@Autowired
	private PlatformMapper platformMapper;
	
	/**
	 * Ajax方式获取到
	 * */
	
	
	/**
	 * 得到所有平台
	 * */
	 public List<Platform> getAllDlapts() { 
		 List<Platform> list = platformMapper.selectByExample(null); 
		 return list; 
	}
	
	
}
