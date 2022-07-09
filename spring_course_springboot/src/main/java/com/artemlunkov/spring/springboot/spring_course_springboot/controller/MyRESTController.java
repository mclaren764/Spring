package com.artemlunkov.spring.springboot.spring_course_springboot.controller;


//import com.artemlunkov.spring.rest.exception_handling.NoSuchEmployeeException;

import com.artemlunkov.spring.springboot.spring_course_springboot.entity.Employee;
import com.artemlunkov.spring.springboot.spring_course_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

//        if(employee == null){
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee editEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
//        if(employee == null) {
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
//        }

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + " was deleted";
    }
}
