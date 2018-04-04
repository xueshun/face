package com.xue.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Segment Hash
 * @Author xueshun
 * @Create 2018-04-04 10:47
 */
public class Demo03 {

    public static void main(String[] args) {
        int segment = 100;
        Jedis jedis = null;
        try{
            jedis = new Jedis(Common.HOST,Common.PORT);
            Map<String,String> kvMap = new HashMap<String,String>();
            for (int i = 0; i <Common.TOTAL_USER_COUNT ; i++) {
                String key = "f:"+String.valueOf(i%segment);
                String value = "v:"+i;
                kvMap.put(key,value);
                if(i % segment==0){
                    System.out.println(i);
                    int hash = (i-1)/segment;
                    jedis.hmset("u"+String.valueOf(hash),kvMap);
                    kvMap = new HashMap<>();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }
}
