//package com.example.redispubsub.user;
//
//import com.example.redispubsub.services.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.validation.Valid;
//
//public class UserService {
//    @Autowired
//    private RedisService redisService;
//
//    public User add(User user) {
//        redisService.put(user.getId(), user);
//        return user;
//    }
//
//}
