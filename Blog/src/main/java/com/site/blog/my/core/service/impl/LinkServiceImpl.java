package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogLinkMapper;
import com.site.blog.my.core.entity.BlogLink;
import com.site.blog.my.core.service.LinkService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-24 09:01
 **/

@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private BlogLinkMapper blogLinkMapper;

    @Override
    public PageResult getBlogLinkPage(PageQueryUtil pageUtil) {
        List<BlogLink> links = blogLinkMapper.findLinkList(pageUtil);
        int total = blogLinkMapper.getTotalLinks(pageUtil);
        PageResult pageResult = new PageResult(links
                ,total
                , pageUtil.getLimit()
                , pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getTotalLinks() {
        return 0;
    }

    @Override
    public Boolean saveLink(BlogLink link) {
        return null;
    }

    @Override
    public BlogLink selectById(Integer id) {
        return null;
    }

    @Override
    public Boolean updateLink(BlogLink tempLink) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public Map<Byte, List<BlogLink>> getLinksForLinkPage() {
        return null;
    }
}
