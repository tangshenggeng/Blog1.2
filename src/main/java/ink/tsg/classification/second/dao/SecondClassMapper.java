package ink.tsg.classification.second.dao;

import ink.tsg.classification.second.bean.SecondClass;
import ink.tsg.classification.second.bean.SecondClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondClassMapper {
    long countByExample(SecondClassExample example);

    int deleteByExample(SecondClassExample example);

    int deleteByPrimaryKey(Integer sclassificationId);

    int insert(SecondClass record);

    int insertSelective(SecondClass record);
    //联合查询出一级分类
    List<SecondClass> selectByExampleWhitFC(SecondClassExample example);
    
    List<SecondClass> selectByExample(SecondClassExample example);

    SecondClass selectByPrimaryKey(Integer sclassificationId);

    int updateByExampleSelective(@Param("record") SecondClass record, @Param("example") SecondClassExample example);

    int updateByExample(@Param("record") SecondClass record, @Param("example") SecondClassExample example);

    int updateByPrimaryKeySelective(SecondClass record);

    int updateByPrimaryKey(SecondClass record);
}