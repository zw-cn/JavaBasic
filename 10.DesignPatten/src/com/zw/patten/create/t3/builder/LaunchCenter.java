package com.zw.patten.create.t3.builder;

/**
 * @program: JavaBasic
 * @description: 发射中心（client）
 * @author: zw-cn
 * @create: 2020-02-28 17:39
 */
public class LaunchCenter {
    public static void main(String[] args) {
        AirshipBuilder builder = new TeslaAirshipBuilder();
        AirshipDirector director = new ShanghaiAirshipDirector(builder);
        Airship airship = director.directorAirship();
        airship.launch();
    }
}
