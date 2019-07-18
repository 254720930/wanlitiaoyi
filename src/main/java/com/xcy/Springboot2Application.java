package com.xcy;

import com.xcy.utils.JedisClient;
import com.xcy.utils.JedisClientPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
@EnableSwagger2
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

    @Value("${spring.redis.host}")
    String host ;

    @Value("${spring.redis.port}")
    int port ;


    @Bean  // <bean id='' class=“”/>
    public JedisClient getJedisClient(){
        JedisClientPool jedisClient =new JedisClientPool();
        JedisPool jedisPool =new JedisPool(host,port);
        jedisClient.setJedisPool(jedisPool);
        return jedisClient;
    }

}
