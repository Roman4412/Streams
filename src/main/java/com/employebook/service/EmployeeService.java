package com.employebook.service;

import com.employebook.Employee;

import java.util.List;
import java.util.Map;


public interface EmployeeService {
    Employee add(String firstName, String lastname, int department, double salary);
    Employee remove(String firstName, String lastname, int department, double salary);
    Employee find(String firstName, String lastname, int department, double salary);
    Employee findMaxSalary(int department);
    Employee findMinSalary(int department);
    List <Employee> printAllDepartment(int department);
    Map<Integer, List<Employee>> printAll();
}
