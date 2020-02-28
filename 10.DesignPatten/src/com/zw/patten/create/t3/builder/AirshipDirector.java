package com.zw.patten.create.t3.builder;

/**
 * @program: JavaBasic
 * @description: 航天飞船Director:装配
 * @author: zw-cn
 * @create: 2020-02-28 17:29
 */
public interface AirshipDirector {
    Airship directorAirship();
}
class ShanghaiAirshipDirector implements AirshipDirector{
    private AirshipBuilder builder;

    public ShanghaiAirshipDirector(AirshipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Airship directorAirship() {
        builder.buildOrbitalModel();
        Airship airship = new Airship();
        airship.setAirEngine(builder.buildAirEngine());
        airship.setEscapeTower(builder.buildEscapeTower());
        airship.setOrbitalModel(builder.buildOrbitalModel());
        return airship;
    }
}