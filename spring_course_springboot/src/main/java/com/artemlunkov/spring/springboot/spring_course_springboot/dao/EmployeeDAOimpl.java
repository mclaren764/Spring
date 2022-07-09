package com.artemlunkov.spring.springboot.spring_course_springboot.dao;


import com.artemlunkov.spring.springboot.spring_course_springboot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

//%%%%%%%%%%%%%%%%%%%%%%% HIBERTNATE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public Employee getEmployee(int id) {

        Employee employee = entityManager.find(Employee.class, id);

//%%%%%%%%%%%%%%%%%%%%%%% HIBERTNATE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

//%%%%%%%%%%%%%%%%%%%%%%% HIBERTNATE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

    }

    @Override
    public void saveEmployee(Employee employee) {

//%%%%%%%%%%%%%%%%%%%%%%% HIBERTNATE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }
}
