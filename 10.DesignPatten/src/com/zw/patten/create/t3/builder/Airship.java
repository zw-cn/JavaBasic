package com.zw.patten.create.t3.builder;

/**
 * @program: JavaBasic
 * @description: 航天飞船
 * @author: zw-cn
 * @create: 2020-02-28 17:09
 */
public class Airship {
    private OrbitalModel orbitalModel;
    private AirEngine airEngine;
    private EscapeTower escapeTower;

    public void launch(){
        System.out.println(airEngine.getName()+"点火，发射！");
    }
    public OrbitalModel getOrbitalModel() {
        return orbitalModel;
    }

    public void setOrbitalModel(OrbitalModel orbitalModel) {
        this.orbitalModel = orbitalModel;
    }

    public AirEngine getAirEngine() {
        return airEngine;
    }

    public void setAirEngine(AirEngine airEngine) {
        this.airEngine = airEngine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}
/**
 * @description: 轨道舱
 * @author: zw-cn
 * @create: 2/28/2020 5:13 PM
 */
class OrbitalModel{
    private String name;

    public OrbitalModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/**
 * @description: 航空发动机
 * @author: zw-cn
 * @create: 2/28/2020 5:13 PM
 */
class AirEngine{
    private String name;

    public AirEngine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/**
 * @description: 逃逸塔
 * @author: zw-cn
 * @create: 2/28/2020 5:14 PM
 */
class EscapeTower{
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}