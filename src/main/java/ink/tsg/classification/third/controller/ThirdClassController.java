package ink.tsg.classification.third.controller;

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

import ink.tsg.classification.second.bean.SecondClass;
import ink.tsg.classification.second.bean.SecondClassExample;
import ink.tsg.classification.third.bean.ThirdClass;
import ink.tsg.classification.third.bean.ThirdClassExample;
import ink.tsg.classification.third.bean.ThirdClassExample.Criteria;
import ink.tsg.classification.third.service.ThirdClassService;
import ink.tsg.utlis.Msg;

@Controller
@ResponseBody
public class ThirdClassController {
	
	@Autowired
	private ThirdClassService thirdClassService;
	
	/**
	 * 根据外键查询三级分类
	 * */
	@RequestMapping(value="/getAllThclassByFk/{tcScId}",method=RequestMethod.GET)
	public Msg getClassByFK(@PathVariable("tcScId") Integer id) {
		ThirdClassExample thirdClassExample = new ThirdClassExample();
		Criteria criteria = thirdClassExample.createCriteria();
		criteria.andTcScIdEqualTo(id);
		List<ThirdClass> list = thirdClassService.getClassByFK(thirdClassExample);
		return Msg.success().add("thClassByFK", list);
	}
	
	
	/**
	 * 根据id修改三级分类信息
	 * */
	@RequestMapping(value="/editTC/{tclassificationId}",method=RequestMethod.PUT)
	public Msg editSC(@PathVariable("tclassificationId")Integer tclassificationId,@Valid ThirdClass thirdClass,BindingResult result) {
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
				Long count = findByName(thirdClass.getTclassificationName(),thirdClass.getTcScId());
				if(count == 0) {
					thirdClassService.editTC(thirdClass);
					return Msg.success();
				}else {
					return Msg.fail().add("error", "该分类已存在！");
				}
			}
	}
	/**
	 * 修改前的准备，根据id查询出信息
	 * */
	@RequestMapping(value="/reEditTC/{tclassificationId}",method=RequestMethod.GET)
	public Msg getForPreEdit(@PathVariable("tclassificationId")Integer tclassificationId) {
		ThirdClass thirdClass = thirdClassService.findByTCId(tclassificationId);
		return Msg.success().add("getTCById",thirdClass);
	}
	
	/**
	 * 删除一个分类
	 * */
	@RequestMapping(value="/deltcById/{tclassificationId}",method=RequestMethod.DELETE)
	public Msg deltcById(@PathVariable("tclassificationId")Integer tclassificationId) {
		try {
			thirdClassService.deltc(tclassificationId);
			return Msg.success().add("success", "删除成功！");
		} catch (Exception e) {
			return Msg.fail().add("error", "删除失败，该分类下还有文章");
		}
	}
	/**
	 * 添加三级分类
	 * */
	@RequestMapping(value = "/addTC",method=RequestMethod.POST)
	public Msg addTClass(@Valid ThirdClass thirdClass,BindingResult result) {
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
			Long count = findByName(thirdClass.getTclassificationName(),thirdClass.getTcScId());
			if(count == 0) {
				thirdClassService.addtc(thirdClass);
				return Msg.success();
			}else {
				return Msg.fail().add("error", "该分类已存在！");
			}
		}
		
	}
	//添加前，验证是否有重复的分类
	private Long findByName(String sclassificationName,Integer id) {
		ThirdClassExample thirdClassExample = new ThirdClassExample();
		Criteria criteria = thirdClassExample.createCriteria();
		criteria.andTclassificationNameEqualTo(sclassificationName);
		criteria.andTcScIdEqualTo(id);
		Long count = thirdClassService.findTCByName(thirdClassExample);
		return count;
	}
	/**
	 * 获取所有的三级分类，联合
	 * */
	@RequestMapping(value = "/getThirdWhitSC",method=RequestMethod.GET)
	public Msg getAllTClass() {
		List<ThirdClass> list = thirdClassService.getAllTClasswhitSC();
		return Msg.success().add("whitSC", list);
	}
	/**
	 * 获取所有的三级分类，非联合
	 * */
	@RequestMapping(value="/getAllThird",method=RequestMethod.GET)
	public Msg getAllThird() {
		List<ThirdClass> list = thirdClassService.getAllThird();
		return Msg.success().add("tclass", list);
	}
	
	
}
