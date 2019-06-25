package ink.tsg.classification.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ink.tsg.classification.first.bean.FirstClass;
import ink.tsg.classification.first.bean.FirstClassExample;
import ink.tsg.classification.first.dao.FirstClassMapper;

@Service
public class FirstClassService {
	
	@Autowired
	private FirstClassMapper firstClassMapper;
	/**
	 * 查询所有一级分类的信息
	 * */
	public List<FirstClass> getFirstClass() {
		return firstClassMapper.selectByExample(null);
	}
	//根据名称查询一级分类
	public Long findFCByName(FirstClassExample firstClassExample) {
		return firstClassMapper.countByExample(firstClassExample);
	}
	//添加分类
	public void addByName(FirstClass firstClass) {
		firstClassMapper.insertSelective(firstClass);
	}
	//根据Id删除
	public void delById(Integer id) {
		firstClassMapper.deleteByPrimaryKey(id);
	}
	//通过Id查询一级分类
	public FirstClass getById(Integer fclassificationId) {
		return firstClassMapper.selectByPrimaryKey(fclassificationId);
	}
	//修改分类
	public void editFC(FirstClass firstClass) {
		firstClassMapper.updateByPrimaryKeySelective(firstClass);	
	}
}
