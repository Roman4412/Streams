package com.employebook.service;

import com.employebook.Employee;
import com.employebook.Exceptions.EmployeeAlreadyAddedException;
import com.employebook.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastname, int department, double salary) throws EmployeeAlreadyAddedException {
        Employee emp = new Employee (firstName, lastname, department, salary);
        employees.put(emp.getFullName(), emp);
        if(employees.containsKey(emp.getFullName())) {
            throw new  EmployeeAlreadyAddedException();
        }
        employees.put(emp.getFullName(), emp);
        return emp;
    }

    @Override
    public Employee remove(String firstName, String lastname, int department, double salary) {
        Employee emp = new Employee (firstName, lastname, department, salary);
        if(employees.containsKey(emp.getFullName())) {
            return employees.remove(emp.getFullName());
        }
        throw  new EmployeeNotFoundException();

    }

    @Override
    public Employee find(String firstName, String lastname, int department, double salary) throws EmployeeNotFoundException {
        Employee emp = new Employee (firstName, lastname, department, salary);
         if (employees.containsKey(emp.getFullName())) {
             return employees.get(emp.getFullName());
         }
         throw new EmployeeNotFoundException();
    }
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
