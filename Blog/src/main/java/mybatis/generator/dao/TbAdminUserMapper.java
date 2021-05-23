package mybatis.generator.dao;

import java.util.List;
import mybatis.generator.model.TbAdminUser;
import mybatis.generator.model.TbAdminUserExample;
import org.apache.ibatis.annotations.Param;

public interface TbAdminUserMapper {
    long countByExample(TbAdminUserExample example);

    int deleteByExample(TbAdminUserExample example);

    int deleteByPrimaryKey(Integer adminUserId);

    int insert(TbAdminUser record);

    int insertSelective(TbAdminUser record);

    List<TbAdminUser> selectByExample(TbAdminUserExample example);

    TbAdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByExampleSelective(@Param("record") TbAdminUser record, @Param("example") TbAdminUserExample example);

    int updateByExample(@Param("record") TbAdminUser record, @Param("example") TbAdminUserExample example);

    int updateByPrimaryKeySelective(TbAdminUser record);

    int updateByPrimaryKey(TbAdminUser record);

    /**
     * @Description: 登陆方法
     * @Param: username password
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    TbAdminUser login(@Param("userName") String userName,@Param("password") String password);
}