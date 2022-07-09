package com.artemlunkov.spring.rest;

import com.artemlunkov.spring.rest.configuration.MyConfig;
import com.artemlunkov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();

//        Employee employee = communication.getEmployee(1);

//        Employee employee = new Employee("Ivan", "Blinov", "IT", 2000);
//        employee.setId(9);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(10);

//        System.out.println(employee);
    }
}
