package com.sparksql;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Map;

import static org.apache.spark.sql.functions.*;

/**
 * @CLassName: Test_sparkAggFunc
 * @Author： 46433
 * @Date： 2021/8/31 23:13
 * @Description TODO
 */
public class Test_sparkAggFunc {
    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder()
                .appName("AggFunc")
                .master("local")
                .getOrCreate();

        sparkSession.sparkContext().setLogLevel("ERROR");

        Dataset<Row> orderDF = sparkSession.read().json("data/orders.json");
        orderDF.show();

//        Dataset<Row> aggDF = orderDF.groupBy("userId")
//                .agg(avg("totalPrice").alias("avg"),
//                        max("totalPrice").alias("max"),
//                        sum("totalPrice").alias("sum"));
//        aggDF.show();

        Map<String, String> map = new HashMap<>();
        map.put("totalPrice", "avg");
        map.put("totalPrice", "max");
        map.put("totalPrice", "min");
//        map.put("totalPrice", "sum");

        Dataset<Row> aggDF = orderDF.groupBy("userId").agg(map);
        aggDF.show();


        sparkSession.stop();


    }
}
