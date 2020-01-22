package com.example.redispubsub.pubsub;

import com.example.redispubsub.services.RedisService;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubSubServiceImpl implements PubSubService {
    private final RedisService redisService;


    @Autowired
    public PubSubServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }


    @Override
    public <T> void publish(String topic, T message) {
        redisService.getTopic(topic).publish(message);

    }


    @Override
    public <T> void subscribe(String name, final PubSubListener listener) {
        System.out.println(listener.getClass());
        RTopic topic = redisService.getTopic(name);
        int regId = topic.addListener(Object.class, new MessageListener<Object>() {
            @Override
            public void onMessage(CharSequence channel, Object msg) {
                listener.onMessage(msg);

            }
        });
    }

}
