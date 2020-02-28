package com.zw.patten.create.t3.builder;

/**
 * @program: JavaBasic
 * @description: 航天飞船Builder
 * @author: zw-cn
 * @create: 2020-02-28 17:17
 */
public interface AirshipBuilder {
    AirEngine buildAirEngine();
    EscapeTower buildEscapeTower();
    OrbitalModel buildOrbitalModel();
}
