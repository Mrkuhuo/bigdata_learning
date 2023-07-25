package com.wlb.flink.test;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class MysqlTest {

    public static void main(String[] args) throws Exception {
        //1.获取stream的执行环境
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();
        senv.setParallelism(1);
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().useBlinkPlanner().build();
        //2.创建表执行环境
        StreamTableEnvironment tEnv = StreamTableEnvironment.create(senv,settings);

        String sourceTable = "CREATE TABLE mysql_source (" +
                "  id INT,\n" +
                "  username STRING,\n" +
                "  score INT \n" +

                ") WITH (\n" +
                "'connector' = 'mysql-cdc',\n" +
                "'hostname' = '192.168.56.104',\n" +
                "'port' = '3306',\n" +
                "'database-name' = 'flink',\n" +
                "'table-name' = 'student',\n" +
                "'username' = 'root',\n" +
                "'password' = 'root',\n" +
                "'table-name' = 'student'\n" +
                ")";
        tEnv.executeSql(sourceTable);
       // tEnv.executeSql("select * from mysql_source").print();
        String sinkTable = "CREATE TABLE mysql_sink (" +
                "  username STRING,\n" +
                "  score INT,\n" +
                "  primary key (username) NOT ENFORCED\n" +
                ") WITH (\n" +
                "'connector' = 'jdbc',\n" +
                "'driver' = 'com.mysql.cj.jdbc.Driver',\n" +
                "'url' = 'jdbc:mysql://192.168.56.104:3306/flink?rewriteBatchedStatements=true',\n" +
                "'username' = 'root',\n" +
                "'password' = 'root',\n" +
                "'table-name' = 'result'\n" +
                ")";
        tEnv.executeSql(sinkTable);
        tEnv.executeSql("insert into mysql_sink select username,sum ( score ) as score  from mysql_source group by username ");

    }
}
