package com.zcl.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author: zcl
 * @create: 2022/1/28 13:54
 */
public class JedisUtils {
    private static JedisPool jedisPool;
    static {
        //读取jedisconfig.properties配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jedisconfig");
        Integer maxTotal = Integer.valueOf(resourceBundle.getString("jedis.maxTotal"));
        Integer maxIdle = Integer.valueOf(resourceBundle.getString("jedis.maxIdle"));
        Integer maxWaitMillis = Integer.valueOf(resourceBundle.getString("jedis.maxWaitMillis"));
        String host = resourceBundle.getString("jedis.host");
        Integer port = Integer.valueOf(resourceBundle.getString("jedis.port"));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxTotal(maxIdle);
        jedisPoolConfig.setMaxTotal(maxWaitMillis);
        //使用jedis连接池
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }
    /**
     * 从连接池获取连接
     * @return
     * */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
