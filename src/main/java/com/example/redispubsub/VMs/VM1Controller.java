package com.example.redispubsub.VMs;


import com.example.redispubsub.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vm1")
public class VM1Controller {
    private final VM1 vm1;

    @Autowired
    public VM1Controller(VM1 vm1) {
        this.vm1 = vm1;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@Valid @RequestBody User user) {
        vm1.add(user);
        return user;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") final String id) {
        return null;
    }

    @RequestMapping(value = "/{id}/{topic}", method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") final String id, @PathVariable("topic") final String topic) {
        return vm1.delete(id, topic);


    }

    @RequestMapping(value = "/subscribe/{topic}", method = RequestMethod.GET)
    public String subscribe(@PathVariable("topic") final String topic) throws InterruptedException {
        vm1.listen(topic);
        return topic;
    }


}
