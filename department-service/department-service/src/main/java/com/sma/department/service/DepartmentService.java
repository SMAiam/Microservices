package com.sma.department.service;


import com.sma.department.entity.Department;
import com.sma.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//In an application, the business logic resides within the service layer
//so we use the @Service Annotation to indicate that a class belongs to that layer.
//It is also a specialization of @Component Annotation like the @Repository Annotation.
public class DepartmentService {
   @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService ");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService ");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
