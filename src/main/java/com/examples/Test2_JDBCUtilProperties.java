package com.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @CLassName: Test2_JDBCUtilProperties
 * @Author： 46433
 * @Date： 2021/8/25 22:49
 * @Description TODO
 */
public class Test2_JDBCUtilProperties {
    public static final Logger LOGGER = LoggerFactory.getLogger(Test2_JDBCUtilProperties.class);

    public static void main(String[] args) {



        JDBCUtil jdbcUtil = JDBCUtil.getInstance();
        String user = jdbcUtil.getVauleOfKey("jdbc.user");
        System.out.println(user);

        String url = jdbcUtil.getVauleOfKey("jdbc.url");

        // 打印到日志中
        LOGGER.info("-----------------------------------------");
        LOGGER.info("jdbc.user = {},   jdbc.url = {}", user, url);
    }
}
