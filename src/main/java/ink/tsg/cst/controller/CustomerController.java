package ink.tsg.cst.controller;
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

import ink.tsg.cst.bean.Customer;
import ink.tsg.cst.bean.CustomerExample;
import ink.tsg.cst.bean.CustomerExample.Criteria;
import ink.tsg.cst.service.CustomerService;
import ink.tsg.utlis.Msg;

/**
 * 客户控制层
 * 
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * 查询未删除总人数 
	 * */
	@RequestMapping(value="/cstUnDel",method=RequestMethod.GET)
	@ResponseBody
	public Msg cstUnDel() {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelEqualTo(false);
		Long count = customerService.cstUnDel(example);
		return Msg.success().add("cstUnDel", count);
	}
	
	/**
	 * 查询已经删除总人数 
	 * */
	@RequestMapping(value="/countCstOfDel",method=RequestMethod.GET)
	@ResponseBody
	public Msg countCstOfDel() {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelEqualTo(true);
		Long count = customerService.countCst(example);
		return Msg.success().add("countCstOfDel", count);
	}
	
	/**
	 * 修改员工
	 * */
	@RequestMapping(value="/editCst/{cstId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg edit(Customer customer) {
		customerService.editCst(customer);
		return Msg.success();
	}
	
	/**
	 * 修改之前的准备
	 * */
	@RequestMapping(value="/preEdit/{cstId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg preEdit(@PathVariable("cstId")Integer preId){
		Customer customer = customerService.getById(preId);
		return Msg.success().add("cstById", customer);
	}
	
	
	/**
	 * 彻底删除
	 * */
	@RequestMapping(value="/delCstThoroug/{delId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delCstThoroug(@PathVariable("delId")Integer delId) {
		customerService.delCstThoroug(delId);
 		return Msg.success();
	}
	/**
	 * 删除（假）
	 * */
	@ResponseBody
	@RequestMapping(value="/delCst/{delId}",method=RequestMethod.PUT)
	public Msg updateDel(@PathVariable("delId")Integer delId) {
		Customer customer = customerService.getById(delId);
		customer.isDel(true);
		customerService.updateById(customer);
		return Msg.success();
	}
	/**
	 * 筛选查询
	 * */
	@RequestMapping(value="/screenCsts",method=RequestMethod.POST)
	@ResponseBody
	public Msg screenCsts(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Customer customer) {
		//设置开始分页的信息 
		PageHelper.startPage(pn, 5); 
		CustomerExample example = new CustomerExample();
		
		Criteria criteria = example.createCriteria();
		//设置排序方式，根据cst_id倒序
		String orderByClause = "c.cst_id DESC";
		criteria.andDelEqualTo(false);
		criteria.andCstConLike("%"+customer.getCstCon()+"%");
		criteria.andCstScnLike("%"+customer.getCstNum()+"%");
		criteria.andCstNumLike("%"+customer.getCstScn()+"%");
		example.setOrderByClause(orderByClause);
		
		List<Customer> csts = customerService.screenCsts(example);
		PageInfo<Customer> page = new PageInfo<Customer>(csts, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 提交客户信息
	 * 使用JSR303校验
	 * */
	@RequestMapping(value="/cst",method=RequestMethod.POST)
	@ResponseBody
	public Msg upCustomer(@Valid Customer customer,BindingResult result) {
		if(result.hasErrors()) {
			//创建一个map，把错误信息添加到map中
			Map<String,Object> map = new HashMap<>();
			//校验失败的错误信息
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			java.util.Date utilDate = new java.util.Date();  //获取当前时间
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  //通过getTime()转换
			customer.setUpTime(sqlDate);
			//false表示非删除
			customer.isDel(false);
			customerService.saveEmp(customer);
			return Msg.success();
		}
	}
	/**
	 * 查询已删除
	 * */
	@RequestMapping(value="/cstsDel",method=RequestMethod.GET) 
	  public String del(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
		  // 分页查询引入PageHelper分页插件 
		  //设置开始分页的信息 
		  PageHelper.startPage(pn, 5); 
		  //得到example创建条件
		  CustomerExample example = new CustomerExample();
		  
		  //设置排序方式，根据cst_id倒序
		  String orderByClause = "c.cst_id DESC";
		  example.setOrderByClause(orderByClause);
		  //得到criteria拼装条件
		  Criteria criteria = example.createCriteria();
		  criteria.andDelEqualTo(true);
		  
		  
		  
		  List<Customer> custs =customerService.getAllDel(example); 
		  // 使用pageInfo包装查询后的结果,第二个参数是要连续显示的页码数
		  PageInfo<Customer> page = new PageInfo<Customer>(custs, 5);
		  model.addAttribute("pageInfo_del", page); 
		  return "/LJ-CST-admin/allDelCsts"; 
	  }
	  /**
	   * 查询未删除的客户
	   * */
	  @RequestMapping("/csts") 
	  public String unDel(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
		  // 分页查询引入PageHelper分页插件 
		  //设置开始分页的信息 
		  PageHelper.startPage(pn, 5); 
		  //得到example创建条件
		  CustomerExample example = new CustomerExample();
		  //设置排序方式，根据cst_id倒序
		  String orderByClause = "c.cst_id DESC";
		  example.setOrderByClause(orderByClause);
		  //得到criteria拼装条件
		  Criteria criteria = example.createCriteria();
		  criteria.andDelEqualTo(false);
		  List<Customer> custs =customerService.getAllUndel(example); 
		  // 使用pageInfo包装查询后的结果,第二个参数是要连续显示的页码数
		  PageInfo<Customer> page = new PageInfo<Customer>(custs, 5);
		  model.addAttribute("pageInfo", page);
		  return "/LJ-CST-admin/allCsts"; 
	  }
	  /**
	   * 进入主页
	   * */
	  @RequestMapping("/intoMain") 
	  public String intoMain() {
		  return "/LJ-CST-admin/cst_main";
	  }
}
