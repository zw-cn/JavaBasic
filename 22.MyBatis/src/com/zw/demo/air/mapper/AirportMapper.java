package com.zw.demo.air.mapper;

import com.zw.demo.air.pojo.Airport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.demo.air.mapper</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public interface AirportMapper {
    @Select("select id,name portName,city cityName from airport")
    List<Airport> airports();
    Airport getAirportById(int id);
}
