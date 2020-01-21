package com.example.redispubsub;

import com.example.redispubsub.caches.Cache1;
import com.example.redispubsub.caches.Cache2;
import com.example.redispubsub.caches.Cache3;
import com.example.redispubsub.services.RedisService;
import com.example.redispubsub.services.RedisServiceImpl;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfiguration {
//    @Bean(name = "config")
//    public Config getConfig(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        return config;
//    }
//    @Bean(name = "redisservice")
//    public RedisServiceImpl getRedisService(Config config){
//        return new RedisServiceImpl(config);
//    }

    @Bean
    RedissonClient getRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient client = Redisson.create(config);
        return client;
    }
    @Bean(name="redisservice")
    RedisService getRedisService( RedissonClient  redissonClient){
        return  new RedisServiceImpl(redissonClient);
    }
    @Bean(name="cache1")
    Cache1 getCache1( RedisService redisService){
       return new Cache1(redisService);
    }
    @Bean(name="cache2")
    Cache2 getCache2(RedisService redisService){
        return new Cache2(redisService);
    }
    @Bean(name="cache3")
    Cache3 getCache3(RedisService redisService){
        return new Cache3(redisService);
    }
}
