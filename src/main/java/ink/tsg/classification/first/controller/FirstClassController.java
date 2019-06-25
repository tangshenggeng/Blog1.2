package ink.tsg.classification.first.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ink.tsg.classification.first.bean.FirstClass;
import ink.tsg.classification.first.bean.FirstClassExample;
import ink.tsg.classification.first.bean.FirstClassExample.Criteria;
import ink.tsg.classification.first.service.FirstClassService;
import ink.tsg.utlis.Msg;

@Controller
@ResponseBody
public class FirstClassController {
	
	@Autowired
	private FirstClassService firstClassService;
	
	/**
	 * 查询所有一级分类的信息
	 * */
	@RequestMapping(value="/getFirstClass",method=RequestMethod.GET)
	
	public Msg getFirstClass() {
		List<FirstClass> list=firstClassService.getFirstClass();
		return Msg.success().add("firstClass", list);
	}
	/**
	 * 添加一级分类
	 * */
	@RequestMapping(value = "/addFirstClass",method=RequestMethod.POST)
	public Msg addFirstClass(@Valid FirstClass firstClass,BindingResult result) {
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
			Long count = findByName(firstClass.getFclassificationName());
			if(count == 0) {
				firstClassService.addByName(firstClass);
				return Msg.success();
			}else {
				return Msg.fail().add("error", "该分类已存在！");
			}
		}
	}
	//根据名称查询
	private Long findByName(String fclassificationName) {
		FirstClassExample firstClassExample = new FirstClassExample();
		Criteria criteria = firstClassExample.createCriteria();
		criteria.andFclassificationNameEqualTo(fclassificationName);
		Long count = firstClassService.findFCByName(firstClassExample);
		return count;
	}
	//根据ID删除分类
	@RequestMapping(value="/delTcById/{fclassificationId}",method=RequestMethod.DELETE)
	public Msg delById(@PathVariable("fclassificationId") Integer id) {
		try {
			firstClassService.delById(id);
			return Msg.success().add("success", "删除成功！");
		} catch (Exception e) {
			return Msg.fail().add("error", "删除失败！可能是该分类下还存在分类！");
		}
	}
	//修改前的准备
	@RequestMapping(value="/getTcById/{fclassificationId}",method=RequestMethod.GET)
	public Msg getTcById(@PathVariable("fclassificationId") Integer fclassificationId){
		FirstClass firstClass = firstClassService.getById(fclassificationId);
		return Msg.success().add("getFcById", firstClass);
		
	}
	//修改
	@RequestMapping(value="/editFc/{fclassificationId}",method=RequestMethod.PUT)
	public Msg editFc(@PathVariable("fclassificationId")Integer fclassificationId,@Valid FirstClass firstClass,BindingResult result) {
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
			Long count = findByName(firstClass.getFclassificationName());
			if(count == 0) {
				firstClassService.editFC(firstClass);
				return Msg.success();
			}else {
				return Msg.fail().add("error", "该分类已存在！");
			}
		}
	}
}
