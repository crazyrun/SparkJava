package com.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @CLassName: Test2_PropertiesReadDemo
 * @Author： 46433
 * @Date： 2021/8/25 22:30
 * @Description TODO
 */
public class JDBCUtil {
    private static JDBCUtil jdbcUtil;
    private static Properties props;

    // 构造器中 读取配置文件，将配置文件转化为输入流，并加载
    private JDBCUtil(){
        props = new Properties();
        InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");  // 将配置文件转为输入流
        try {
            props.load(in);   // load配置文件的输入流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取对象
    public static JDBCUtil getInstance(){ // 某个类的方法是静态方法，则不需要new对象，直接通过 类型.静态方法名调用
        if(jdbcUtil == null){
            jdbcUtil = new JDBCUtil();
        }
        return jdbcUtil;
    }

    // 定义获取key的值
    public String getVauleOfKey(String key){
        String value = props.getProperty(key);
        return value;
    }

}
