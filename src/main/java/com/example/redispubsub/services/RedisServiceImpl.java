package com.example.redispubsub.services;

import org.redisson.api.RKeys;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class RedisServiceImpl implements RedisService {

    private RedissonClient redissonClient;

    @Autowired
    public RedisServiceImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    public <T> T put(String key, T value) {
        redissonClient.getBucket(key).set(value);
        return value;
    }

    @Override
    public <T> T get(String key) {
        return (T) redissonClient.getBucket(key).get();
    }

    @Override
    public <T> T delete(String key) {
        T obj = (T) redissonClient.getBucket(key).get();
        redissonClient.getBucket(key).delete();
        return obj;
    }

//    @Override
//    public void listen(String topic) throws InterruptedException {
//        RTopic rTopic = redissonClient.getTopic(topic);
//        CountDownLatch latch = new CountDownLatch(2);
//        ((RTopic) rTopic).addListener(String.class, new MessageListener<String>() {
//            @Override
//            public void onMessage(CharSequence channel, String msg) {
//                System.out.println(msg);
//                latch.countDown();
//            }
//        });
//        latch.await();
//    }

    @Override
    public <T> void publish(String topic, T message) {
        RTopic rTopic = redissonClient.getTopic(topic);
        rTopic.publish(message);
    }

    @Override
    public RedissonClient getClient() {
        return redissonClient;
    }

    @Override
    public <T> Map<String,T> getAll() {
        RKeys rKeys=redissonClient.getKeys();
        Iterable<String> keys = rKeys.getKeys();
        Map<String,T> map=new HashMap<>();
        for (String key: keys ) {
            map.put(key,this.get(key));
        }
        return  map;

    }
}
