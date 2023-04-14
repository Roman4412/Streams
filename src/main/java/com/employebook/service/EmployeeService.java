package com.employebook.service;

import com.employebook.Employee;
import com.employebook.Exceptions.EmployeeAlreadyAddedException;

public interface EmployeeService {
    Employee add(String firstName, String lastname, int department, double salary) throws EmployeeAlreadyAddedException;
    Employee remove(String firstName, String lastname, int department, double salary);
    Employee find(String firstName, String lastname, int department, double salary);


}
