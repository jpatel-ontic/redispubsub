package com.example.redispubsub.caches;

import com.example.redispubsub.services.RedisService;
import com.example.redispubsub.user.User;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;


public class Cache1 {
    private Map<String, User> localCache;
    private RedisService redisService;


    @Autowired
    public Cache1(RedisService redisService) {
        this.localCache = new HashMap<>();
        this.redisService = redisService;
        //this.redissonClient=redissonClient;
    }

    public void listen(String topic) throws InterruptedException {
        RTopic rTopic = redisService.getClient().getTopic(topic);
        // CountDownLatch latch = new CountDownLatch(2);
        ((RTopic) rTopic).addListener(String.class, new MessageListener<String>() {
            @Override
            public void onMessage(CharSequence channel, String msg) {
                System.out.println(msg + " " + "cache1");
                //  latch.countDown();

                updateLocalCache();
                for(Map.Entry<String ,User> entry : localCache.entrySet()){
                    System.out.println("keys=" +entry.getKey() + " " +entry.getValue());
                }


            }
        });
        // latch.await();
    }

    public void clearLocalCache() {
        localCache.clear();

    }

    public void updateLocalCache() {
        clearLocalCache();
        this.localCache = redisService.getAll();
    }


}
