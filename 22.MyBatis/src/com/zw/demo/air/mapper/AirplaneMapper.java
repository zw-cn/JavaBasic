package com.zw.demo.air.mapper;

import com.zw.demo.air.pojo.Airplane;
import org.apache.ibatis.annotations.Param;

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
public interface AirplaneMapper {
    List<Airplane> airplanes(@Param("takeId") int takeId,@Param("landId")  int landId);
}
