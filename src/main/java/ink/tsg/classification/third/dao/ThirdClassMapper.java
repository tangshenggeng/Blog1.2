package ink.tsg.classification.third.dao;

import ink.tsg.classification.third.bean.ThirdClass;
import ink.tsg.classification.third.bean.ThirdClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdClassMapper {
    long countByExample(ThirdClassExample example);

    int deleteByExample(ThirdClassExample example);

    int deleteByPrimaryKey(Integer tclassificationId);

    int insert(ThirdClass record);

    int insertSelective(ThirdClass record);
    //联合查询出二级分类的信息
    List<ThirdClass> selectByExampleWhitSC(ThirdClassExample example);
    
    List<ThirdClass> selectByExample(ThirdClassExample example);

    ThirdClass selectByPrimaryKey(Integer tclassificationId);

    int updateByExampleSelective(@Param("record") ThirdClass record, @Param("example") ThirdClassExample example);

    int updateByExample(@Param("record") ThirdClass record, @Param("example") ThirdClassExample example);

    int updateByPrimaryKeySelective(ThirdClass record);

    int updateByPrimaryKey(ThirdClass record);
}