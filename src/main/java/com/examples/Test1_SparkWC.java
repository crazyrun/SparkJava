package com.examples;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import java.util.Arrays;

/**
 * @CLassName: Test1_SparkWC
 * @Author： 46433
 * @Date： 2021/8/25 21:23
 * @Description TODO
 */
public class Test1_SparkWC {
    public static void main(String[] args) throws InterruptedException {
        // 1 SparkConf
        SparkConf conf = new SparkConf().setAppName("sparkTest1").setMaster("local");

        // 2 SparkContext
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> stringRDD = jsc.textFile("data/1.txt");
        JavaRDD<String> wordRDD = stringRDD.flatMap(line -> {
            String[] words = line.split(" ");
            return Arrays.asList(words).iterator();
        });

        // 3 变换
        System.out.println(wordRDD.count());

        // 4 输出

        Thread.sleep(1000000);

        // 5 关闭
        jsc.stop();
    }
}
