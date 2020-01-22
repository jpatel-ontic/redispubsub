package com.example.redispubsub.services;

import org.redisson.api.RTopic;

import java.util.Map;


public interface RedisService {

    <T> T put(String key, T value);

    <T> T get(String key);

    <T> T delete(String key);

    // void listen(String topic) throws InterruptedException;

    // <T> void publish(String topic, T message);

    <T> Map<String, T> getAll();
    RTopic getTopic(String topic);
}