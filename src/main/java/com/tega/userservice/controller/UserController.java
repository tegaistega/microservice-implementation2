package com.tega.userservice.controller;

import com.tega.userservice.entity.User;
import com.tega.userservice.service.UserService;
import com.tega.userservice.valueObject.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateValueObject getUserWithDepartment(@PathVariable("id") Long id){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(id);
    }
}
