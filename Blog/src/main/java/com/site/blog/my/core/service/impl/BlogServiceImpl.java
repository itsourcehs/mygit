package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.controller.vo.BlogDetailVO;
import com.site.blog.my.core.controller.vo.SimpleBlogListVO;
import com.site.blog.my.core.dao.*;
import com.site.blog.my.core.entity.*;
import com.site.blog.my.core.service.BlogService;
import com.site.blog.my.core.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-20 14:36
 **/

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogTagMapper blogTagMapper;

    @Resource
    private BlogTagRelationMapper blogTagRelationMapper;
    /**
     * @Description: 
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    @Override
    @Transactional
    public String saveBlog(Blog blog) {
        BlogCategory blogCategory = blogCategoryMapper
                .selectByPrimaryKey(blog.getBlogCategoryId());
        if(blogCategory == null){
            blog.setBlogCategoryId(0);
            blog.setBlogCategoryName("默认分类");
        }else {
            /**设置博客分类名称*/
            blog.setBlogCategoryName(blogCategory
                    .getCategoryName());

            /**分类排序值+1*/
            blogCategory.setCategoryRank(blogCategory
                    .getCategoryRank()+1);
        }
        /**处理标签数据*/
        String[] tags = blog
                .getBlogTags()
                .split(",");
        if(tags.length >6 ){
            return "标签数量限制为6";
        }
        /**保存博客文章*/
        if(blogMapper.insertSelective(blog) > 0){
            /**新增的tag对象*/
            List<BlogTag> tagListForInsert = new ArrayList<>();
            /**所有的tag对象,用于建立关系数据*/
            List<BlogTag> allTagsList = new ArrayList<>();
            for(int i=0;i< tags.length;i++){
                BlogTag tag = blogTagMapper.selectByTagName(tags[i]);
                if(tag == null){
                    /**标签不存在则新增*/
                    BlogTag tempTag = new BlogTag();
                    tempTag.setTagName(tags[i]);
                    tagListForInsert.add(tempTag);
                }else {
                    allTagsList.add(tag);
                }
            }
            /**新增标签数据并修改分类排序值*/
            if(!CollectionUtils.isEmpty(tagListForInsert)){
                blogTagMapper.batchInsertBlogTag(tagListForInsert);
            }
            blogCategoryMapper.updateByPrimaryKeySelective(blogCategory);
            List<BlogTagRelation> blogTagRelations = new ArrayList<>();
            /**新增数据关系*/
            allTagsList.addAll(tagListForInsert);
            for(BlogTag tag :allTagsList){
                BlogTagRelation blogTagRelation = new BlogTagRelation();
                blogTagRelation.setBlogId(blog.getBlogId());
                blogTagRelation.setTagId(tag.getTagId());
                blogTagRelations.add(blogTagRelation);
            }
            if(blogTagRelationMapper.batchInsert(blogTagRelations)>0){
                return "success";
            }
        }
        return "保存失败";
    }

    @Override
    public PageResult getBlogsPage(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public int getTotalBlogs() {
        return blogMapper.getTotalBlogs(null);
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return null;
    }

    @Override
    public String updateBlog(Blog blog) {
        return null;
    }

    @Override
    public PageResult getBlogsForIndexPage(int page) {
        return null;
    }

    @Override
    public List<SimpleBlogListVO> getBlogListForIndexPage(int type) {
        return null;
    }

    @Override
    public BlogDetailVO getBlogDetail(Long blogId) {
        return null;
    }

    @Override
    public PageResult getBlogsPageByTag(String tagName, int page) {
        return null;
    }

    @Override
    public PageResult getBlogsPageByCategory(String categoryId, int page) {
        return null;
    }

    @Override
    public PageResult getBlogsPageBySearch(String keyword, int page) {
        return null;
    }

    @Override
    public BlogDetailVO getBlogDetailBySubUrl(String subUrl) {
        Blog blog = blogMapper.selectBySubUrl(subUrl);
        /**不为空且状态为已发布*/
        BlogDetailVO blogDetailVO = getBlogDetailVO(blog);
        if(blogDetailVO != null){
            return blogDetailVO;
        }
        return null;
    }

    /**
     * @Description:
     * @Param: 方法抽取
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/22
     */
    private BlogDetailVO getBlogDetailVO(Blog blog){
        return null;
    }
}
