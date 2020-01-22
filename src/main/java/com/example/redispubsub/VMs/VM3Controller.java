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
//@RequestMapping("/vm3")
//public class VM3Controller {
//    private  VM3 vm3;
//    @Autowired
//    public VM3Controller(VM3 vm3) {
//        this.vm3 = vm3;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public User add(@Valid @RequestBody User user) {
//        vm3.add(user);
//        return user;
//    }
//
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
