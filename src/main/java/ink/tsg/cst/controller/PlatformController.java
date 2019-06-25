package ink.tsg.cst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ink.tsg.cst.bean.Platform;
import ink.tsg.cst.service.PlatformService;
import ink.tsg.utlis.Msg;
/**
 * 平台控制层
 * */
@Controller
public class PlatformController {
	
	@Autowired
	private PlatformService platformServic;
	
	/**
	 * 得到所有平台
	 * */
	@RequestMapping(value="/plats",method=RequestMethod.GET)
	@ResponseBody
	public Msg getAllDlapts() {
		List<Platform> plats = platformServic.getAllDlapts();
		return Msg.success().add("plats", plats);
	}
	
}
