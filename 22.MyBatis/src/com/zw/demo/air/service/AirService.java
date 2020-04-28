package com.zw.demo.air.service;

import com.zw.demo.air.pojo.Airplane;
import com.zw.demo.air.pojo.Airport;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.demo.air.service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public interface AirService {
    List<Airport> airports();
    Airport getAirportById(int id);
    List<Airplane> airplanes(int takeId,int landId);
}
