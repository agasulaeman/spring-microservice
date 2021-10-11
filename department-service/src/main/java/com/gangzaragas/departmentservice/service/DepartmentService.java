package com.gangzaragas.departmentservice.service;

import com.gangzaragas.departmentservice.entity.Department;
import com.gangzaragas.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment (Department department){
        log.info("Processing Save Department");
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartmentById(Long departmentId){
       log.info("Processing find department Id ");
       return departmentRepository.findById(departmentId);
    }
}
