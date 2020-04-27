package com.zw.limit.pojo;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.limit.pojo</p>
 * <p>Description: 分页对象</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public class PageInfo {
    /** 每页的个数 */
    private Integer pageSize;
    /** 页号 */
    private Integer pageNumber;
    /** 每页合计 */
    private Integer pageTotal;
    /** 查询结果 */
    private List<?> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
