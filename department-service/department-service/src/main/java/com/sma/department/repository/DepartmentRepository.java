package com.sma.department.repository;

import com.sma.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Spring Repository annotation is a specialization of @Component annotation,
//        so Spring Repository classes are autodetected by spring framework through classpath scanning. Spring Repository is very close to DAO pattern where DAO classes are responsible for providing CRUD operations on database tables. However,
//        if you are using Spring Data for managing database operations,
//        then you should use Spring Data Repository interface.
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentId(Long departmentId);
}
