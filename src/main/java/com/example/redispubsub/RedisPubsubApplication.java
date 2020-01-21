package com.example.redispubsub;

import com.example.redispubsub.caches.Cache1;
import com.example.redispubsub.caches.Cache2;
import com.example.redispubsub.caches.Cache3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RedisPubsubApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RedisPubsubApplication.class, args);
        ApplicationContext appcontext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Cache1 cache1 = (Cache1) appcontext.getBean("cache1");
        cache1.listen("ontic");
        cache1.listen("student");

        Cache2 cache2 = (Cache2) appcontext.getBean("cache2");
        cache2.listen("ontic");
        Cache3 cache3 = (Cache3) appcontext.getBean("cache3");


        cache3.listen("ontic");


    }

}
