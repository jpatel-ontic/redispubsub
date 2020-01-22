package com.example.redispubsub.VMs;

import com.example.redispubsub.pubsub.PubSubService;
import com.example.redispubsub.user.User;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VM1 {
    private Map<String, User> localCache;
    private PubSubService pubSubService;


    @Autowired
    public VM1(PubSubService pubSubService) {
        this.localCache = new HashMap<>();
        this.pubSubService = pubSubService;
    }

//    public void listen(String topic) throws InterruptedException {
//        RTopic rTopic = this.pubSubService.getTopic(topic);
//        // CountDownLatch latch = new CountDownLatch(2);
//        ((RTopic) rTopic).addListener(String.class, new MessageListener<String>() {
//            @Override
//            public void onMessage(CharSequence channel, String msg) {
//                System.out.println("vm1" + " " + msg);
//                //  latch.countDown();
//
//                // updateLocalCache();
////                for (Map.Entry<String, User> entry : localCache.entrySet()) {
////                    System.out.println("keys=" + entry.getKey() + " " + entry.getValue());
////                }
//
//
//            }
//        });
//    }
//    public void listen(String topic) throws InterruptedException {
//        System.out.println("VM1 lisitin ");
//        RTopic rTopic = this.pubSubService.getTopic(topic);
//        // CountDownLatch latch = new CountDownLatch(2);
//        System.out.println("vm1 after gettopic ");
//        ((RTopic) rTopic).addListener(Object.class, new MessageListener<Object>() {
//
//            @Override
//            public void onMessage(CharSequence channel, Object msg) {
//                //System.out.println("vm1" + " " + msg.toString());
//                System.out.println(msg.getClass());
//                User user=(User)msg;
//                System.out.println(user.getName());
//                //  latch.countDown();
//                System.out.println("vm1");
//                // updateLocalCache();
////                for (Map.Entry<String, User> entry : localCache.entrySet()) {
////                    System.out.println("keys=" + entry.getKey() + " " + entry.getValue());
////                }
//
//
//            }
//        });
//    }


    public void listen(String topic) throws InterruptedException {
        System.out.println("VM1 lisitin ");
        RTopic rTopic = this.pubSubService.getTopic(topic);
        // CountDownLatch latch = new CountDownLatch(2);
        System.out.println("vm1 after gettopic ");
        rTopic.addListener(User.class, new MessageListener<User>() {

            @Override
            public void onMessage(CharSequence channel, User msg) {
                System.out.println("vm1" + " " + msg.toString());
                System.out.println("vm1");
                // updateLocalCache();
//                for (Map.Entry<String, User> entry : localCache.entrySet()) {
//                    System.out.println("keys=" + entry.getKey() + " " + entry.getValue());
//                }


            }
        });
    }
//    public <T extends User> void listen(String name) {
//        // String name = type.toString();
//        RTopic topic = this.pubSubService.getTopic(name);
//        System.out.println("lsiten");
//        int regId = topic.addListener(User.class, new MessageListener<User>() {
//            @Override
//            public void onMessage(CharSequence channel, User msg) {
//                System.out.println("new "+ msg.toString());
//                System.out.println(msg.getName());
//            }
//        });
//    }

    public void add(User user) {
        localCache.put(user.getId(), user);
    }

    public User delete(String id,String topic) {
        User user = localCache.get(id);
        localCache.remove(id);
        //this.pubSubService.publish(topic, "delete user " + " " + id+ "on topic= "+ topic);
        this.pubSubService.publish(topic, user);
        return user;
    }



}
