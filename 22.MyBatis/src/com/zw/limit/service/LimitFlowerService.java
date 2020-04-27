package com.zw.limit.service;

import com.zw.limit.pojo.PageInfo;

/**
 * <p>Title: JavaBasic-com.zw.limit.service</p>
 * <p>Description: 分页</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public interface LimitFlowerService {
    PageInfo pageFlowers(int pageNumber,int pageSize);
}
