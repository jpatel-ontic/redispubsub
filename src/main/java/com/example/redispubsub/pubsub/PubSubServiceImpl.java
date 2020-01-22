package com.example.redispubsub.pubsub;

import com.example.redispubsub.services.RedisService;
import org.redisson.api.RTopic;
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
    public <T> T getTopic(String topic) {
        RTopic rTopic = redisService.getTopic(topic);
        return (T) rTopic;
    }

}
