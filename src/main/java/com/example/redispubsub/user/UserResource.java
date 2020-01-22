package com.example.redispubsub.user;

import com.example.redispubsub.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private RedisService redisService;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public User add(@Valid @RequestBody User user) {
//        redisService.put(user.getId(), user);
//        redisService.publish("ontic", "Invalidation");
//        redisService.publish("student", "Invalidation student");
//        return user;
//    }
//
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User get(@PathVariable("id") final String id) {
//        return (User) redisService.get(id);
//
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public User delete(@PathVariable("id") final String id) {
//            User user=(User) redisService.get(id);
//            redisService.delete(id);
//         redisService.publish("ontic", "Invalidation");
//        return user;
//
//    }


}
