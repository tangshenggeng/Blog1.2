package ink.tsg.classification.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.classification.third.bean.ThirdClass;
import ink.tsg.classification.third.bean.ThirdClassExample;
import ink.tsg.classification.third.dao.ThirdClassMapper;

@Service
public class ThirdClassService {

	@Autowired
	private ThirdClassMapper thirdClassMapper;
	
	/**
	 * 获取所有三级信息
	 * @param example 
	 * */
	public List<ThirdClass> getAlltc(ThirdClassExample example) {
		return thirdClassMapper.selectByExampleWhitSC(example);
	}
	/**
	 * 添加一个三级分类
	 * */
	public void addtc(ThirdClass thirdClass) {
		thirdClassMapper.insert(thirdClass);
	}
	/**
	 * 删除一个分类
	 * */
	public void deltc(Integer tclassificationId) {
		thirdClassMapper.deleteByPrimaryKey(tclassificationId);
	}
	/**
	 * 修改前的准备，根据id查询出信息
	 * */
	public ThirdClass findByTCId(Integer tclassificationId) {
		return thirdClassMapper.selectByPrimaryKey(tclassificationId);
	}
	/**
	 * 修改分类信息
	 * */
	public void editTC(ThirdClass thirdClass) {
		thirdClassMapper.updateByPrimaryKeySelective(thirdClass);
	}
	
	public List<ThirdClass> getAllTClasswhitSC() {
		return thirdClassMapper.selectByExampleWhitSC(null);
	}
	//验证名字是否重复
	public Long findTCByName(ThirdClassExample thirdClassExample) {
		return thirdClassMapper.countByExample(thirdClassExample);
	}
	public List<ThirdClass> getAllThird() {
		return thirdClassMapper.selectByExample(null);
	}
	public List<ThirdClass> getClassByFK(ThirdClassExample thirdClassExample) {
		return thirdClassMapper.selectByExample(thirdClassExample);
	}
	
}
