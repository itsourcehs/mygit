package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.BlogLink;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;

import java.util.List;
import java.util.Map;

public interface LinkService {
    /**
     * @Description: 查询友链的分页数据
     * @Param: pageUtil
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    int getTotalLinks();

    /**
     * @Description: 保存
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer id);

    Boolean updateLink(BlogLink tempLink);

    /**
     * @Description: 批量删除
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * @Description: 返回友链页面所需的所有数据
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    Map<Byte, List<BlogLink>> getLinksForLinkPage();
}
