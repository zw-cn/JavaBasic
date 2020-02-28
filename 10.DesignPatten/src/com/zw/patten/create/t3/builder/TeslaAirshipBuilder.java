package com.zw.patten.create.t3.builder;

/**
 * @program: JavaBasic
 * @description: 特斯拉火箭制造中心
 * @author: zw-cn
 * @create: 2020-02-28 17:20
 */
public class TeslaAirshipBuilder implements AirshipBuilder{
    @Override
    public AirEngine buildAirEngine() {
        return new BJAirEngineFactory().createAirEngine();
    }

    @Override
    public EscapeTower buildEscapeTower() {
        return new EscapeTower("Made by PRC");
    }

    @Override
    public OrbitalModel buildOrbitalModel() {
        return new OrbitalModel("Made in Xi'an");
    }
}
interface AirEngineFactory{
    AirEngine createAirEngine();
}
class BJAirEngineFactory implements AirEngineFactory{
    @Override
    public AirEngine createAirEngine() {
        return new AirEngine("北京航天专用发动机");
    }
}