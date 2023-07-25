package com.wlb.flink.test;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.shaded.curator4.com.google.common.reflect.Parameter;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class StreamWordCount {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        int port = Integer.valueOf(parameterTool.get("port"));
        DataStreamSource<String> stringDataStreamSource = env.socketTextStream(host, port);
        SingleOutputStreamOperator<Tuple2<String, Long>> tuple2SingleOutputStreamOperator = stringDataStreamSource.flatMap((String line, Collector<Tuple2<String, Long>> var2) -> {
            String[] split = line.split(",");
            for (String s : split) {
                var2.collect(Tuple2.of(s, 1L));
            }
        }).returns(Types.TUPLE(Types.STRING,Types.LONG));
        KeyedStream<Tuple2<String, Long>, String> tuple2StringKeyedStream = tuple2SingleOutputStreamOperator.keyBy(x -> x.f0);
        SingleOutputStreamOperator<Tuple2<String, Long>> sum = tuple2StringKeyedStream.sum(1);
        sum.print();
        env.execute();
    }

}
