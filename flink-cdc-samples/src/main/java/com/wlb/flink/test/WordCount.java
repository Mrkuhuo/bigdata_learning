package com.wlb.flink.test;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;


public class WordCount {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<String> stringDataSource = executionEnvironment.readTextFile("C:/Users/wlb/Desktop/test.txt");

        FlatMapOperator<String, Tuple2<String, Long>> returns = stringDataSource.flatMap((String line, Collector<Tuple2<String, Long>> out) -> {
            String[] split = line.split(",");
            for (String s : split) {
                out.collect(Tuple2.of(s, 1L));
            }

        }).returns(Types.TUPLE(Types.STRING, Types.LONG));

        UnsortedGrouping<Tuple2<String, Long>> tuple2UnsortedGrouping = returns.groupBy(0);
        AggregateOperator<Tuple2<String, Long>> sum = tuple2UnsortedGrouping.sum(1);
        sum.print();


    }
}
