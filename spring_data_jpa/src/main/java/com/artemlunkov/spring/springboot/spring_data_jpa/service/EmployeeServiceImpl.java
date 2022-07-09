package com.artemlunkov.spring.springboot.spring_data_jpa.service;

import com.artemlunkov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.artemlunkov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> opt = employeeRepository.findById(id);
        if(opt.isPresent()){
            employee = opt.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> emps = employeeRepository.findAllByName(name);
        return emps;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
