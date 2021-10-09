package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogTagMapper;
import com.site.blog.my.core.dao.BlogTagRelationMapper;
import com.site.blog.my.core.entity.BlogTag;
import com.site.blog.my.core.entity.BlogTagCount;
import com.site.blog.my.core.service.TagService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-23 19:46
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private BlogTagMapper blogTagMapper;
    @Resource
    private BlogTagRelationMapper relationMapper;

    @Override
    public PageResult getBlogTagPage(PageQueryUtil pageUtil) {
        List<BlogTag> tags = blogTagMapper.findTagList(pageUtil);
        int total = blogTagMapper.getTotalTags(pageUtil);
        PageResult pageResult = new PageResult(tags
                ,total
                , pageUtil.getLimit()
                , pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getTotalTags() {
        return 0;
    }

    @Override
    public Boolean saveTag(String tagName) {
        BlogTag temp = blogTagMapper.selectByTagName(tagName);
        if(temp == null){
            BlogTag blogTag = new BlogTag();
            blogTag.setTagName(tagName);
            return blogTagMapper.insertSelective(blogTag) >0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        /**存在关联关系的不删除*/
        List<Long> relations = relationMapper.selectDistinctTagIds(ids);
        if(!CollectionUtils.isEmpty(relations)){
            return false;
        }
        /**不存在关联则删除*/
        return blogTagMapper.deleteBatch(ids) >0;
    }

    @Override
    public List<BlogTagCount> getBlogTagCountForIndex() {
        return null;
    }
}
