package ink.tsg.classification.second.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ink.tsg.classification.first.bean.FirstClassExample;
import ink.tsg.classification.second.bean.SecondClass;
import ink.tsg.classification.second.bean.SecondClassExample;
import ink.tsg.classification.second.bean.SecondClassExample.Criteria;
import ink.tsg.classification.second.service.SecondClassService;
import ink.tsg.utlis.Msg;

@Controller
@ResponseBody
public class SecondClassController {
	
	@Autowired
	private SecondClassService secondClassService;
	
	
	
	
	/**
	 * 根据id修改二级分类信息
	 * */
	@RequestMapping(value="/editSC/{sclassificationId}",method=RequestMethod.PUT)
	public Msg editSC(@PathVariable("sclassificationId")Integer sclassificationId,@Valid SecondClass secondClass,BindingResult result) {
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
				//添加之前 先根据名称查看是否已经存在
				Long count = findByName(secondClass.getSclassificationName(),secondClass.getScFcId());
				if(count == 0) {
					secondClassService.editSC(secondClass);
					return Msg.success();
				}else {
					return Msg.fail().add("error", "该分类已存在！");
				}
			}
	}
	/**
	 * 修改前的准备，通过Id查询二级分类
	 * */
	@RequestMapping(value="/getScById/{sclassificationId}",method=RequestMethod.GET)
	public Msg getScById(@PathVariable("sclassificationId")Integer sclassificationId) {
		SecondClass secondClass = secondClassService.getScById(sclassificationId);
		return Msg.success().add("getScById", secondClass);
	}
	/**
	 * 查询所有的二级分类（非联合）
	 * */
	@RequestMapping(value="/getAllSecond",method=RequestMethod.GET)
	public Msg getAllSecondClass() {
		List<SecondClass> list = secondClassService.getAllSecond();
		return Msg.success().add("allSecond", list);
	}
	
	/**
	 * 联合查询出一级分类
	 * */
	@RequestMapping(value="/getSecondWhitFC",method=RequestMethod.GET)
	public Msg getSecondWhitFC() {
		List<SecondClass> list = secondClassService.getSecondWhitFC();
		return Msg.success().add("whitFC", list);
	}
	/**
	  * 添加二级分类
	 * */
	@RequestMapping(value="/addFC",method=RequestMethod.POST)
	public Msg addFC(@Valid SecondClass secondClass,BindingResult result) {
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
			//添加之前 先根据名称查看是否已经存在
			Long count = findByName(secondClass.getSclassificationName(),secondClass.getScFcId());
			if(count == 0) {
				secondClassService.addSC(secondClass);
				return Msg.success();
			}else {
				return Msg.fail().add("error", "该分类已存在！");
			}
		}
	}
	//根据名称查询
	private Long findByName(String sclassificationName,Integer id) {
		SecondClassExample secondClassExample = new SecondClassExample();
		Criteria criteria = secondClassExample.createCriteria();
		criteria.andSclassificationNameEqualTo(sclassificationName);
		criteria.andScFcIdEqualTo(id);
		Long count = secondClassService.findFCByName(secondClassExample);
		return count;
	}
	/**
	 * 删除一个二级分类
	 * */
	@RequestMapping(value="/delSC/{sclassificationId}",method=RequestMethod.DELETE)
	public Msg delSC(@PathVariable("sclassificationId")Integer sclassificationId) {
		try{
			secondClassService.delSC(sclassificationId);
			return Msg.success().add("success", "删除成功");
		}catch (Exception e) {
			return Msg.fail().add("error", "删除失败，可能是因为该分类下还有文章");
		}
	}
	
	
	
}
