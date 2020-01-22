package com.example.redispubsub.pubsub;

import org.springframework.stereotype.Component;

public interface PubSubService {
    <T> void  publish(String topic,T message);
    <T> T getTopic(String topic);
   // <T> void  subscribe (String topic,final PubSubListener<T> listener);




}
