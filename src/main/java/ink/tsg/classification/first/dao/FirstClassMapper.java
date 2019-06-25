package ink.tsg.classification.first.dao;

import ink.tsg.classification.first.bean.FirstClass;
import ink.tsg.classification.first.bean.FirstClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstClassMapper {
    long countByExample(FirstClassExample example);

    int deleteByExample(FirstClassExample example);

    int deleteByPrimaryKey(Integer fclassificationId);

    int insert(FirstClass record);

    int insertSelective(FirstClass record);

    List<FirstClass> selectByExample(FirstClassExample example);

    FirstClass selectByPrimaryKey(Integer fclassificationId);

    int updateByExampleSelective(@Param("record") FirstClass record, @Param("example") FirstClassExample example);

    int updateByExample(@Param("record") FirstClass record, @Param("example") FirstClassExample example);

    int updateByPrimaryKeySelective(FirstClass record);

    int updateByPrimaryKey(FirstClass record);
}