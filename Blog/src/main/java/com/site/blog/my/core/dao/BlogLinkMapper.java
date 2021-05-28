package com.site.blog.my.core.dao;
import com.site.blog.my.core.entity.BlogLink;
import com.site.blog.my.core.util.PageQueryUtil;
import mybatis.generator.model.BlogLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogLinkMapper {
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

    List<BlogLink> findLinkList(PageQueryUtil pageUtil);

    int getTotalLinks(PageQueryUtil pageUtil);
}