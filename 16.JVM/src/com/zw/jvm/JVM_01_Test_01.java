package com.zw.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.jvm</p>
 * <p>Description: 查看JVM信息</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/28/2020
 */
public class JVM_01_Test_01 {
    /**
     * <p>Description: 获取收集器信息</p>
     * -XX:+UseSerialGC 添加运行参数的运行结果
     * Copy
     * MarkSweepCompact
     * @param args
     * @return void
     * @throws 
     * @author zw-cn
     * @date: 3/28/2020 4:59 PM
     */
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : list) {
            System.out.println(bean.getName());
        }
    }
}
