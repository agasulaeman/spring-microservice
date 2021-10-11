package com.gangzaragas.userservice.service;

import com.gangzaragas.userservice.entity.User;
import com.gangzaragas.userservice.repository.UserRepository;
import com.gangzaragas.userservice.vo.Department;
import com.gangzaragas.userservice.vo.ResponseTemplateVO;
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
        log.info("Processing Saving in User Service");
        return userRepository.save(user);
    }

    public User findByUserId(Long userId){
        log.info("Processing finduser based on Id in User Service");
       return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserDepartmentWithId(Long userId){
        ResponseTemplateVO  vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +
                user.getDepartmentId(),Department.class);

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
