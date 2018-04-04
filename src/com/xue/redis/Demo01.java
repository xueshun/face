package com.xue.redis;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 纯字符
 *
 * @Author xueshun
 * @Create 2018-04-04 10:25
 */
public class Demo01 {

    public static void main(String[] args) {
        int mBatchSize = 2000;
        Jedis jedis = null;
        try {
            jedis = new Jedis(Common.HOST, Common.PORT);
            List<String> kvsList = Lists.newArrayList();
            for (int i = 0; i < Common.TOTAL_USER_COUNT; i++) {
                String key = "u:" + i;
                kvsList.add(key);
                String value = "v:" + i;
                kvsList.add(value);
                if (i % mBatchSize == 0) {
                    System.out.println(i);
                    jedis.mset(kvsList.toArray(new String[kvsList.size()]));
                    kvsList = Lists.newArrayList();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }
}
