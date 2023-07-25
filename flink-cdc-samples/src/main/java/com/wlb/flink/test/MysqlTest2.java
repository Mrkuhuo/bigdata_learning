package com.wlb.flink.test;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class MysqlTest2 {

    public static void main(String[] args) throws Exception {
        //1.获取stream的执行环境
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();
        senv.setParallelism(1);
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().useBlinkPlanner().build();
        //2.创建表执行环境
        StreamTableEnvironment tEnv = StreamTableEnvironment.create(senv,settings);

        String sourceTable = "CREATE TEMPORARY TABLE mysql_source (" +
                "  id INT,\n" +
                "  username STRING,\n" +
                "  score INT ,\n" +
                "  datestr STRING ,\n" +
                "  ts as CAST(to_timestamp(datestr) as timestamp(3)) ,\n" +
                " rowtime AS PROCTIME(),\n " +
                "  WATERMARK FOR ts as ts - INTERVAL '10' SECOND \n " +
                ") WITH (\n" +
                "'connector' = 'jdbc',\n" +
                "'driver' = 'com.mysql.cj.jdbc.Driver',\n" +
                "'url' = 'jdbc:mysql://192.168.56.104:3306/flink?rewriteBatchedStatements=true',\n" +
                "'username' = 'root',\n" +
                "'password' = 'root',\n" +
                "'table-name' = 'student'\n" +
                ")";
        tEnv.executeSql(sourceTable);
        //tEnv.executeSql("select * from mysql_source").print();
        tEnv.executeSql("create view plus_offline_data as select username,sum(score),HOP_START (ts, INTERVAL '1' MINUTE,INTERVAL '1' DAY),\n" +
                "    HOP_END (ts, INTERVAL '1' MINUTE, INTERVAL '1' DAY) from mysql_source group by" +
                " HOP (ts, INTERVAL '1' MINUTE, INTERVAL '1' DAY), username");

        String sinkTable = "CREATE TABLE mysql_sink (" +
                "  username STRING,\n" +
                "  score INT,\n" +
                "  start_time timestamp,\n" +
                "  end_time timestamp,\n" +
                "  primary key (username) NOT ENFORCED\n" +
                ") WITH (\n" +
                "'connector' = 'jdbc',\n" +
                "'driver' = 'com.mysql.cj.jdbc.Driver',\n" +
                "'url' = 'jdbc:mysql://192.168.56.104:3306/flink?rewriteBatchedStatements=true',\n" +
                "'username' = 'root',\n" +
                "'password' = 'root',\n" +
                "'table-name' = 'result_copy'\n" +
                ")";
       tEnv.executeSql(sinkTable);
       tEnv.executeSql("insert into mysql_sink select * from plus_offline_data");

    }
}
