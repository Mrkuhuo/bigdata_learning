/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.storm.redis.topology;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.redis.bolt.RedisStoreBolt;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.ITuple;

public class PersistentWordCount {
    private static final String WORD_SPOUT = "WORD_SPOUT";
    private static final String COUNT_BOLT = "COUNT_BOLT";
    private static final String STORE_BOLT = "STORE_BOLT";

    private static final String TEST_REDIS_HOST = "127.0.0.1";
    private static final int TEST_REDIS_PORT = 6379;

    public static void main(String[] args) throws Exception {
        String host = TEST_REDIS_HOST;
        int port = TEST_REDIS_PORT;

        if (args.length >= 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig.Builder()
                .setHost(host).setPort(port).build();

        WordSpout spout = new WordSpout();
        WordCounter bolt = new WordCounter();
        RedisStoreMapper storeMapper = setupStoreMapper();
        RedisStoreBolt storeBolt = new RedisStoreBolt(poolConfig, storeMapper);

        // wordSpout ==> countBolt ==> RedisBolt
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout(WORD_SPOUT, spout, 1);
        builder.setBolt(COUNT_BOLT, bolt, 1).fieldsGrouping(WORD_SPOUT, new Fields("word"));
        builder.setBolt(STORE_BOLT, storeBolt, 1).shuffleGrouping(COUNT_BOLT);

        String topoName = "test";
        if (args.length == 3) {
            topoName = args[2];
        } else if (args.length > 3) {
            System.out.println("Usage: PersistentWordCount <redis host> <redis port> (topology name)");
            return;
        }
        Config config = new Config();
        StormSubmitter.submitTopology(topoName, config, builder.createTopology());
    }

    private static RedisStoreMapper setupStoreMapper() {
        return new WordCountStoreMapper();
    }

    private static class WordCountStoreMapper implements RedisStoreMapper {
        private RedisDataTypeDescription description;
        private final String hashKey = "wordCount";

        WordCountStoreMapper() {
            description = new RedisDataTypeDescription(
                    RedisDataTypeDescription.RedisDataType.HASH, hashKey);
        }

        @Override
        public RedisDataTypeDescription getDataTypeDescription() {
            return description;
        }

        @Override
        public String getKeyFromTuple(ITuple tuple) {
            return tuple.getStringByField("word");
        }

        @Override
        public String getValueFromTuple(ITuple tuple) {
            return tuple.getStringByField("count");
        }
    }
}
