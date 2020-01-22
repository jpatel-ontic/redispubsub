//package com.example.redispubsub.VMs;
//
//import com.example.redispubsub.services.RedisService;
//import com.example.redispubsub.user.User;
//import org.redisson.api.RTopic;
//import org.redisson.api.listener.MessageListener;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class VM2<T> {
//    private Map<String, User> localCache;
//    private RedisService redisService;
//
//
//    @Autowired
//    public VM2(RedisService redisService) {
//        this.localCache = new HashMap<>();
//        this.redisService = redisService;
//        //this.redissonClient=redissonClient;
//    }
//
//
//    public void listen(String topic) throws InterruptedException {
//        RTopic rTopic = redisService.getClient().getTopic(topic);
//        // CountDownLatch latch = new CountDownLatch(2);
//        ((RTopic) rTopic).addListener(String.class, new MessageListener<String>() {
//            @Override
//            public void onMessage(CharSequence channel, String msg) {
//                System.out.println(msg + " " + "cache2");
//                //  latch.countDown();
//
//                updateLocalCache();
//            }
//        });
//        // latch.await();
//    }
//
//    public void clearLocalCache() {
//        localCache.clear();
//
//    }
//    public void add(User user){
//        localCache.put(user.getId(),user);
//    }
//
//    public void updateLocalCache() {
//        clearLocalCache();
//        this.localCache = redisService.getAll();
//    }
//
//
//}
