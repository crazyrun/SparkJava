package com.sparksql;

import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.*;

/**
 * @CLassName: Test3_userAndContent
 * @Author： 46433
 * @Date： 2021/9/1 21:06
 * @Description TODO
 */
public class Test3_userAndContent {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("userAndContent")
                .getOrCreate();

        spark.sparkContext().setLogLevel("ERROR");
        //===========================================
        Dataset<Row> dataDF = spark.read()
                .format("csv")
                .option("header", true)
                .load("data/user_content.csv");

        dataDF.show();

        Dataset<Row> agg = dataDF
                .groupBy("source", "pt_d")
                .agg(countDistinct(col("ctype").$eq$eq$eq("news")).alias("newsCount"),
                        countDistinct(col("ctype").contains("video")).alias("videoCount"));

        agg.show();

        dataDF
             .groupBy("source", "pt_d")
             .agg(when(col("ctype").$eq$eq$eq("1"), 1).otherwise(0).alias("click"))
                .withColumn("clickAmout",col("click"))
                .show();


        //===========================================
        spark.stop();
    }
}
