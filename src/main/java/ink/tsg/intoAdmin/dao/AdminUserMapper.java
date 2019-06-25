package ink.tsg.intoAdmin.dao;

import ink.tsg.intoAdmin.bean.AdminUser;
import ink.tsg.intoAdmin.bean.AdminUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);
    //得到一个管理员信息
    AdminUser selectByExampleOfOne(AdminUserExample example);
    
    AdminUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}