//package com.example.redispubsub;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class ApplicationConfiguration {
////    @Bean(name = "config")
////    public Config getConfig(){
////        Config config = new Config();
////        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
////        return config;
////    }
////    @Bean(name = "redisservice")
////    public RedisServiceImpl getRedisService(Config config){
////        return new RedisServiceImpl(config);
////    }
//
//    @Bean
//    RedissonClient getRedissonClient() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        RedissonClient client = Redisson.create(config);
//        return client;
//    }
////    @Bean(name="redisservice")
////    RedisService getRedisService( RedissonClient  redissonClient){
////        return  new RedisServiceImpl(redissonClient);
////    }
////    @Bean(name="cache1")
////    VM1 getCache1(RedisService redisService){
////       return new VM1(redisService);
////    }
////    @Bean(name="cache2")
////    VM2 getCache2(RedisService redisService){
////        return new VM2(redisService);
////    }
////    @Bean(name="cache3")
////    VM3 getCache3(RedisService redisService){
////        return new VM3(redisService);
////    }
//}
