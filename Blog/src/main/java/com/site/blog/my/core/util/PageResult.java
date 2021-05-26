package com.site.blog.my.core.util;

import java.io.Serializable;
import java.util.List;

/**
 * @program: Blog
 * @description: 分页工具类,实现io序列化
 * @author: Mr.Huang
 * @create: 2021-05-20 11:39
 **/

public class PageResult implements Serializable {
    /**总记录数*/
    private int totalCount;
    /**每页记录数*/
    private int pageSize;
    /**总页数*/
    private int totalPage;
    /**当前页数*/
    private int currPage;
    /**列表数据*/
    private List<?> list;

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/20
     */
    public PageResult(List<?> list, int totalCount, int pageSize, int currPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.list = list;
        /**
         * 总记录数/每页记录数 = 总页数
         */
        this.totalPage = (int)Math.ceil((double) totalCount/pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
