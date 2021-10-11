package com.gangzaragas.departmentservice.controller;

import com.gangzaragas.departmentservice.entity.Department;
import com.gangzaragas.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
      log.info("Processing Save Department From controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Optional<Department> findDepartmentById(@PathVariable("departmentId") Long departmentId) {
        log.info("Processing find Department From controller");
        return departmentService.findDepartmentById(departmentId);
    }
}
