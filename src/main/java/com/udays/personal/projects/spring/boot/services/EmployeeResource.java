package com.udays.personal.projects.spring.boot.services;

import com.udays.personal.projects.spring.boot.dao.entity.Employee;
import com.udays.personal.projects.spring.boot.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager entityManager;

    @RequestMapping(method = RequestMethod.GET, path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee(@RequestBody Employee employees){
        employeeRepository.save(employees);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable long id){
        if(!employeeRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        employee.setId(id);
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeRepository.deleteById(id);
    }

}
