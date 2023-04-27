package com.employebook.service;

import com.employebook.Employee;
import java.util.Comparator;

import com.employebook.exceptions.EmployeeAlreadyAddedException;
import com.employebook.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        add("Налог", "Сдоходов>", 1,12_000);
        add("Рекорд", "Надоев>", 2,13_000);
        add("Захват", "Покоев>", 3,14_000);
        add("Вагон", "Опохмелян>", 4,15_000);
        add("Бидон", "Отстоев>", 5,16_000);
        add("Ушат", "Помоев>", 1,17_000);
        add("Рулон", "Обоев>", 2,18_000);
        add("Отлов", "Приматов>", 3,19_000);
        add("Разгул", "Маньяков>", 4,20_000);
        add("Распил", "Самшитов>", 5,21_000);
    }

    @Override
    public Employee add(String firstName, String lastname, int department, double salary) {
        Employee emp = new Employee (firstName, lastname, department, salary);
        employees.put(emp.getFullName(), emp);
        if(employees.containsKey(emp.getFullName())) {
            throw new EmployeeAlreadyAddedException();
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
            throw new EmployeeNotFoundException();
        }

    @Override
    public Employee find(String firstName, String lastname, int department, double salary)  {
        Employee emp = new Employee (firstName, lastname, department, salary);
         if (employees.containsKey(emp.getFullName())) {
             return employees.get(emp.getFullName());
         }
            throw new EmployeeNotFoundException();
    }
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    @Override
    public Employee findMaxSalary(int department) {
        return employees.values().stream()
                .filter(emp -> emp.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();

    }
    @Override
    public Employee findMinSalary(int department) {
        return employees.values().stream()
                .filter(emp -> emp.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();

    }

    @Override
    public List<Employee> printAllDepartment(int department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> printAll() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


    }
}
