package com.zw.traditional.service.impl;

import com.zw.traditional.dao.FlowerDao;
import com.zw.traditional.dao.impl.FlowerDaoImpl;
import com.zw.traditional.pojo.Flower;
import com.zw.traditional.service.FlowerService;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.traditional.service.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/25/2020
 */
public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Override
    public List<Flower> showAll() {
        return flowerDao.selAll();
    }

    @Override
    public int addFlower(Flower flower) {
        return flowerDao.addFlower(flower);
    }
}
