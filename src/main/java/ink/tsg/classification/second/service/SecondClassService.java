package ink.tsg.classification.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.classification.second.bean.SecondClass;
import ink.tsg.classification.second.bean.SecondClassExample;
import ink.tsg.classification.second.dao.SecondClassMapper;

@Service
public class SecondClassService {
	
	@Autowired
	private SecondClassMapper secondClassMapper;
	/**
	 * 联合查询出一级分类
	 * */
	public List<SecondClass> getSecondWhitFC() {
		return secondClassMapper.selectByExampleWhitFC(null);
	}
	/**
	 *  添加二级分类
	 * */
	public void addSC(SecondClass secondClass) {
		secondClassMapper.insertSelective(secondClass);
	}
	/**
	 * 删除一个二级分类
	 * */
	public void delSC(Integer sclassificationId) {
		secondClassMapper.deleteByPrimaryKey(sclassificationId);
	}
	/**
	 * 根据二级分类的id查询出二级分类的信息
	 * */
	public SecondClass findBySCId(Integer sclassificationId) {
		return secondClassMapper.selectByPrimaryKey(sclassificationId);
	}
	/**
	 * 根据id修改二级分类信息
	 * */
	public void editSC(SecondClass secondClass) {
		secondClassMapper.updateByPrimaryKeySelective(secondClass);
	}
	/**
	 * 非联合查询二级分类信息
	 * */
	public List<SecondClass> getWhitoutFclass() {
		return secondClassMapper.selectByExample(null);
	}
	/**
	 * 根据外键查询出特定的二级分类
	 * */
	public List<SecondClass> getAllClassByFK(SecondClassExample secondClassExample) {
		return secondClassMapper.selectByExample(secondClassExample);
	}
	//查询是否重复添加
	public Long findFCByName(SecondClassExample secondClassExample) {
		return secondClassMapper.countByExample(secondClassExample);
	}
	
	public SecondClass getScById(Integer sclassificationId) {
		return secondClassMapper.selectByPrimaryKey(sclassificationId);
	}
	
	public List<SecondClass> getAllSecond() {
		return secondClassMapper.selectByExample(null);
	}
	
	
	
	
}
