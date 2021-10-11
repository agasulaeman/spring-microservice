package com.gangzaragas.userservice.controller;

import com.gangzaragas.userservice.entity.User;
import com.gangzaragas.userservice.service.UserService;
import com.gangzaragas.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
      log.info("Processing Saving in User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/find/{userId}")
    public User findByUserId(@PathVariable("userId") Long userId) {
        log.info("Processing findUser based Id in User Controller");
        return userService.findByUserId(userId);
    }
    @GetMapping("/findBy/{userId}")
    public ResponseTemplateVO getUserDepartmentWithId(@PathVariable("userId")  Long userId){
        log.info("Processing findDepartment based userId in User Controller");
        return userService.getUserDepartmentWithId(userId);
    }
}
