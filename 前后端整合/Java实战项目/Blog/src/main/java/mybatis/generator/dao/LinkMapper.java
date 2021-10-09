package mybatis.generator.dao;

import java.util.List;
import mybatis.generator.model.BlogLink;
import mybatis.generator.model.BlogLinkExample;
import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    long countByExample(BlogLinkExample example);

    int deleteByExample(BlogLinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    List<BlogLink> selectByExample(BlogLinkExample example);

    BlogLink selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") BlogLink record, @Param("example") BlogLinkExample example);

    int updateByExample(@Param("record") BlogLink record, @Param("example") BlogLinkExample example);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);
}