package com.example.redispubsub.pubsub;

public interface PubSubService {
    <T> void publish(String topic, T message);

    void subscribe(String topic, final PubSubListener listener);


}
