package com.example.redispubsub.pubsub;

public interface PubSubListener {
    <T> void onMessage(T data);
}
