package com.zw.simplify.service.impl;

import com.zw.simplify.MyBatisUtils;
import com.zw.simplify.mapper.PeopleMapper;
import com.zw.simplify.pojo.People;
import com.zw.simplify.service.PeopleService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.simplify.service.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public class PeopleServiceImpl implements PeopleService {
    @Override
    public List<People> showPeople() {
        SqlSession session = MyBatisUtils.getSession();
        PeopleMapper mapper = session.getMapper(PeopleMapper.class);
        return mapper.selAll();
    }
}
