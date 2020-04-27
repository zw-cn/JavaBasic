package com.zw.traditional.dao;

import com.zw.traditional.pojo.Flower;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.mybatis</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/25/2020
 */
public interface FlowerDao {
    List<Flower> selAll();

    int addFlower(Flower flower);
}
