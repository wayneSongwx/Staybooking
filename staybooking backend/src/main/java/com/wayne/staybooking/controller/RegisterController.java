package com.wayne.staybooking.controller;

import com.wayne.staybooking.model.User;
import com.wayne.staybooking.model.UserRole;
import com.wayne.staybooking.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public  RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register/guest")
    public void addGuest(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_GUEST);
    }

    @PostMapping("register/host")
    public void addHost(@RequestBody User user) { // @RequestBody: JSON -> object
        registerService.add(user, UserRole.ROLE_HOST);
    }
}
