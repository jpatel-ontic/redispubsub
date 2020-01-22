//package com.example.redispubsub.VMs;
//
//
//import com.example.redispubsub.user.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/vm2")
//public class VM2Controller {
//    private  VM2 vm2;
//    @Autowired
//    public VM2Controller(VM2 vm2) {
//        this.vm2 = vm2;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public User add(@Valid @RequestBody User user) {
//        vm2.add(user);
//        return user;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User get(@PathVariable("id") final String id) {
////        return (User) redisService.get(id);
//        return null;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public User delete(@PathVariable("id") final String id) {
////        User user=(User) redisService.get(id);
////        redisService.delete(id);
////        redisService.publish("ontic", "Invalidation");
////        return user;
//        return null;
//
//    }
//
//
//
//}
