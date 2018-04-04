package com.xue.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * 纯HASH
 *
 * @Author xueshun
 * @Create 2018-04-04 10:42
 */
public class Demo02 {

    public static void main(String[] args) {
        int mBatchSize = 2000;
        String hashKey = "allUser";
        Jedis jedis = null;
        try {
            jedis = new Jedis(Common.HOST, Common.PORT);
            HashMap<String, String> kvMap = new HashMap<String, String>(mBatchSize);
            for (int i = 0; i < Common.TOTAL_USER_COUNT; i++) {
                String key = "u:" + i;
                String value = "v:" + i;
                kvMap.put(key,value);
                if(i%mBatchSize==0){
                    System.out.println(i);
                    jedis.hmset(hashKey,kvMap);
                    kvMap = new HashMap<>(mBatchSize);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }
}
