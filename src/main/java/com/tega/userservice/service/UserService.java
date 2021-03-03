package com.tega.userservice.service;

import com.tega.userservice.entity.User;
import com.tega.userservice.repository.UserRepository;
import com.tega.userservice.valueObject.Department;
import com.tega.userservice.valueObject.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }


    public ResponseTemplateValueObject getUserWithDepartment(Long id) {
        log.info("Inside getUserWithDepartment method of UserController");
        ResponseTemplateValueObject responseTemplateValueObject = new ResponseTemplateValueObject();
        User user = userRepository.findUserById(id);

        Department department =
                restTemplate.getForObject("http://DEPARTMENTSERVICEAPPLICATION/departments/" + user.getDepartmentId(), Department.class
                );
        responseTemplateValueObject.setUser(user);
        responseTemplateValueObject.setDepartment(department);

        return responseTemplateValueObject;
    }
}
