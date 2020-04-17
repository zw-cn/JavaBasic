package com.zw.log4j;

import org.apache.log4j.Logger;

/**
 * <p>Title: JavaBasic-com.zw.log4j</p>
 * <p>Description: 测试Log4j的使用</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/7/2020
 */
public class Test_Log4j_01 {
    static Logger logger = Logger.getLogger(Test_Log4j_01.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.info("This is a info message");
        logger.warn("This is a warn message");
        logger.error("This is a error message");
        logger.fatal("This is a fatal message");
    }
}
