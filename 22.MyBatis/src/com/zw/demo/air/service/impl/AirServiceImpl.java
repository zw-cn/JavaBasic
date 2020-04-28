package com.zw.demo.air.service.impl;

import com.zw.demo.air.mapper.AirplaneMapper;
import com.zw.demo.air.mapper.AirportMapper;
import com.zw.demo.air.pojo.Airplane;
import com.zw.demo.air.pojo.Airport;
import com.zw.demo.air.service.AirService;
import com.zw.simplify.MyBatisUtils2;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.demo.air.service.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class AirServiceImpl implements AirService {
    static {
        MyBatisUtils2.setConfig("mybatis-air.xml");
    }
    private AirplaneMapper airplaneMapper = MyBatisUtils2.getSession().getMapper(AirplaneMapper.class);
    private AirportMapper airportMapper = MyBatisUtils2.getSession().getMapper(AirportMapper.class);
    @Override
    public List<Airport> airports() {
        return airportMapper.airports();
    }

    @Override
    public Airport getAirportById(int id) {
        return airportMapper.getAirportById(id);
    }

    @Override
    public List<Airplane> airplanes(int takeId, int landId) {
        return airplaneMapper.airplanes(takeId, landId);
    }
}
