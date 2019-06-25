package ink.tsg.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.cst.bean.Customer;
import ink.tsg.cst.bean.CustomerExample;
import ink.tsg.cst.dao.CustomerMapper;
/**
 * 客户业务层
 * */
@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	/**
	 * 查询所有未删除客户
	 * */
	public List<Customer> getAllUndel(CustomerExample example){
		List<Customer> custs =  customerMapper.selectByExampleWhitPla(example);
		return custs;
	}
	/**
	 * 保存一个客户
	 * */
	public void saveEmp(Customer customer) {
		customerMapper.insertSelective(customer);
	}
	/**
	 * 查询所有已删除的用户
	 * @param example 
	 * */
	public List<Customer> getAllDel(CustomerExample example) {
		List<Customer> custs =  customerMapper.selectByExampleWhitPla(example);
		return custs;
	}
	/**
	 * 筛选
	 * @param example 
	 * */
	public List<Customer> screenCsts(CustomerExample example) {
		List<Customer> list = customerMapper.selectByExampleWhitPla(example);
		return list;
	}
	/**
	 * 假删除，更新数据库的del
	 * */
	public Customer getById(Integer cstsId) {
		return customerMapper.selectByPrimaryKeyWhitPla(cstsId);
	}
	public void updateById(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}
	/**
	 * 彻底删除
	 * */
	public void delCstThoroug(Integer delId) {
		customerMapper.deleteByPrimaryKey(delId);
	}
	/**
	 * 修改客户
	 * */
	public void editCst(Customer customer) {
		//根据主键有选择地更新
		customerMapper.updateByPrimaryKeySelective(customer);
	}
	/**
	 * 查询已经删除的数目
	 * */
	public Long countCst(CustomerExample example) {
		return customerMapper.countByExample(example);
	}
	/**
	 * 查询未删除的数目
	 * */
	public Long cstUnDel(CustomerExample example) {
		return customerMapper.countByExample(example);
	}
	
	
	
}
