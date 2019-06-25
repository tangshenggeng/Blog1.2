package ink.tsg.cst.dao;

import ink.tsg.cst.bean.Customer;
import ink.tsg.cst.bean.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface  CustomerMapper{
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer cstId);

    int insert(Customer record);

    int insertSelective(Customer record);
   
    List<Customer> selectByExample(CustomerExample example);
    /**
          * 下面两个自定义带平台的查询
     * */
    Customer selectByPrimaryKeyWhitPla(Integer cstId);
    //未删除
    List<Customer> selectByExampleWhitPla(CustomerExample example);

    Customer selectByPrimaryKey(Integer cstId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}