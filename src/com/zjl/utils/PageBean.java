package com.zjl.utils;

import java.util.List;
import com.zjl.utils.conditions.QueryCondition;

/**
 * 封装分页需要的相关参数
 */
public class PageBean<T> {
    private int currentPage = 1; //当前页数，默认显示第一页
    private int pageCount = 5;  //每页显示的行数
    private int totalCount;      //总记录数，查数据库得
    private int totalPage;       //一共能分多少页，计算得
    private List<T> pageData;    //查询到的一页的数据


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (totalCount < pageCount) {  //若结果总数小于默认数量，则只1页
            totalPage = 1;
        } else {    //否则，计算页数
            if (totalCount % pageCount == 0) {
                totalPage = totalCount / pageCount;
            } else {
                totalPage = totalCount / pageCount + 1;
            }
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

}
