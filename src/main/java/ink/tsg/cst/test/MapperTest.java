package ink.tsg.cst.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ink.tsg.cst.bean.Customer;
import ink.tsg.cst.dao.CustomerMapper;
import ink.tsg.cst.dao.PlatformMapper;

/**
 * 测试dao层
 * 使用spring的单元测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	PlatformMapper platformMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void CRUDTest() {
		java.util.Date utilDate = new java.util.Date();  //获取当前时间
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  //通过getTime()转换
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		for (int i = 0; i < 1000; i++) {
			if(i%2 == 0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,1,sqlDate,true));
			}else if(i%3 == 0 ){
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,2,sqlDate,false));
			}else if(i%5 == 0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,3,sqlDate,true));
			}else if(i%7 == 0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,4,sqlDate,false));
			}else if(i%9 ==0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,5,sqlDate,true));
			}else if(i%10 ==0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,6,sqlDate,false));
			}else if(i%11 == 0) {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,7,sqlDate,true));
			}else {
				String uid = UUID.randomUUID().toString().substring(0, 5);
				mapper.insertSelective(new Customer(null,"联系"+uid,"学校"+uid,"账号"+uid,"密码"+uid,"课程"+uid,8,sqlDate,false));
			}
		}
		System.out.println("插入成功");
	}
}
