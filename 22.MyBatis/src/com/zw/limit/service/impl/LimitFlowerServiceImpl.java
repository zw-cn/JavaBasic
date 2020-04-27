package com.zw.limit.service.impl;

import com.zw.limit.pojo.PageInfo;
import com.zw.limit.service.LimitFlowerService;
import com.zw.traditional.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: JavaBasic-com.zw.limit.service.impl</p>
 * <p>Description: 分页查询</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public class LimitFlowerServiceImpl implements LimitFlowerService {
    @Override
    public PageInfo pageFlowers(int pageNumber, int pageSize) {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setPageSize(pageSize);
        Map m = new HashMap();
        m.put("pageNumber",(pageNumber-1)*pageSize);
        m.put("pageSize",pageSize);
        //分页查询结果
        List<Flower> flowers = session.selectList("com.zw.limit.selPage", m);
        pageInfo.setList(flowers);
        //记录条数
        int num = session.selectOne("com.zw.limit.selTotal");
        pageInfo.setPageTotal(num%pageSize==0?num/pageSize:num/pageSize+1);
        return pageInfo;
    }
}
