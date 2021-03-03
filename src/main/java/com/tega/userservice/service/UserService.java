package com.tega.userservice.service;

import com.tega.userservice.entity.User;
import com.tega.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserRepository");
        return userRepository.save(user);
    }
}
