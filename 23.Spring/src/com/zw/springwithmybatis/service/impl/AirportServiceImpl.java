package com.zw.springwithmybatis.service.impl;

import com.zw.springwithmybatis.mapper.AirportMapper;
import com.zw.springwithmybatis.pojo.Airport;
import com.zw.springwithmybatis.service.AirportService;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.springwithmybatis.service.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class AirportServiceImpl implements AirportService {
    private AirportMapper airportMapper;
    @Override
    public List<Airport> airports() {
        return airportMapper.airports();
    }

    public AirportMapper getAirportMapper() {
        return airportMapper;
    }

    public void setAirportMapper(AirportMapper airportMapper) {
        this.airportMapper = airportMapper;
    }
}
