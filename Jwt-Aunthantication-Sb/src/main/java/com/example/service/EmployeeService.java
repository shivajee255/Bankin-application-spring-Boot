package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private List<Employee> employeeList=new ArrayList<>();

    public  EmployeeService(){


        employeeList.add(new Employee(UUID.randomUUID().toString(),"shivajee","shiva@gmail.com"));
        employeeList.add(new Employee(UUID.randomUUID().toString(),"Rishabe","risab@gmail.com"));
    }

    public List<Employee>getEmployeeList(){
        return employeeList;
    }




}
