package com.udays.personal.projects.spring.boot.dao.repository;

import com.udays.personal.projects.spring.boot.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //List<Employee> findAllEmployees();

}
