package com.site.blog.my.core.service;

import com.site.blog.my.core.controller.vo.BlogDetailVO;
import com.site.blog.my.core.controller.vo.SimpleBlogListVO;
import com.site.blog.my.core.entity.Blog;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;


import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-20 14:35
 **/

public interface BlogService {
    /**
     * @Description: 保存博客
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    String saveBlog(Blog blog);
    
    /**
     * @Description: 获取该页下所有的博客信息
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    PageResult getBlogsPage(PageQueryUtil pageUtil);
    
    /**
     * @Description: 是否批量删除
     * @Param: Integer[] ids - 根据数组类型的多个id进行删除
     * @return: Boolean
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * @Description: 获取所有的博客数量
     * @Param:
     * @return: int
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    int getTotalBlogs();

    /**
     * @Description: 根据id获取博客详情
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    Blog getBlogById(Long blogId);

    /**
     * @Description: 后台修改-更新博客
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    String updateBlog(Blog blog);

    /**
     * @Description: 获取首页博客列表
     * @Param:
     * @return: PageResult
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * @Description: 首页侧边栏数据列表
     * 0-点击最多,1-最新发布
     * @Param:
     * @return: List<SimpleBlogListVO>
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * @Description: 博客详情页
     * @Param: Long blogId
     * @return: BlogDetailVO
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * @Description: 根据标签获取博客列表
     * @Param: tagName, page
     * @return: PageResult对象
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    PageResult getBlogsPageByTag(String tagName,int page);

    /**
     * @Description: 根据分类获取博客列表
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    PageResult getBlogsPageByCategory(String categoryId,int page);

    /**
     * @Description: 根据搜索获取博客列表
     * @Param: String keyword,int page
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    PageResult getBlogsPageBySearch(String keyword,int page);

    /**
     * @Description: 根据博客子URl获取博客详情
     * @Param: String subUrl
     * @return: BlogDetailVO对象
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    BlogDetailVO getBlogDetailBySubUrl(String subUrl);


}
