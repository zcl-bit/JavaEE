package com.zcl;

import com.zcl.utils.JedisUtils;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: zcl
 * @create: 2022/1/28 13:53
 * 使用jedis的步骤：
 * 1、创建连接：创建Jedis对象
 * 2、调用Jedis对象的方法操作redis数据库
 * 3、关闭连接
 */
public class TestJedis {

    @Test
    public void test01(){
        //1、创建与服务器的连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2、调用jedis对象的方法操作redis数据库：要调用的方法名和redis操作的命令是一样的
        jedis.set("user:password","123456");
        //3、关闭连接
        jedis.close();
    }
    @Test
    public void test02(){
        //目标:从redis服务器中获取user:nickname的值
        //1.创建于服务器的连接
        Jedis jedis = new Jedis("localhost",6379);
        //2. 调用get(key)
        String nickname = jedis.get("user:nickname");
        System.out.println(nickname);
        jedis.close();
    }
    @Test
    public void test03(){
        //1、创建与服务器的连接
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.setex("user:email",20,"123456@qq.com");
        jedis.close();
    }
    @Test
    public void test04(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxWaitMillis(3000);
        //使用jedis连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        //从连接池获取连接
        Jedis jedis = jedisPool.getResource();

        //调用jedis的方法
        String nickname = jedis.get("user:nickname");
        System.out.println(nickname);
        //将连接池归还回连接池
        jedis.close();
    }
    @Test
    public void test05(){
        //1、获取连接
        Jedis jedis = JedisUtils.getJedis();
        //2、操作redis数据库
        String address = jedis.get("user:address");
        System.out.println(address);
        //3、关闭连接
        jedis.close();
    }
}
