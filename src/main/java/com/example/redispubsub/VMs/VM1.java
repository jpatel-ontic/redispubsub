package com.example.redispubsub.VMs;

import com.example.redispubsub.pubsub.PubSubListener;
import com.example.redispubsub.pubsub.PubSubService;
import com.example.redispubsub.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VM1 implements PubSubListener {
    private Map<String, User> localCache;
    private PubSubService pubSubService;


    @Autowired
    public VM1(PubSubService pubSubService) {
        this.localCache = new HashMap<>();
        this.pubSubService = pubSubService;
    }

    public void add(User user) {
        localCache.put(user.getId(), user);
    }

    public User delete(String id, String topic) {
        User user = localCache.get(id);
        localCache.remove(id);
        this.pubSubService.publish(topic, (Object) user);
        return user;
    }

    public void listen(String topic) {
        this.pubSubService.subscribe(topic, this);
    }



    @Override
    public <T> void onMessage(T data) {
        System.out.println("i got it");

    }
}
