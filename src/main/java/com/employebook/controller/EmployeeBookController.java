package com.employebook.controller;

import com.employebook.Employee;
import com.employebook.service.EmployeeService;
import com.employebook.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/departments")
public class EmployeeBookController {
    private final EmployeeService employeeService = new EmployeeServiceImpl();


    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam("department") int department) {
        return employeeService.findMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee findMinSalary(@RequestParam("department") int department) {
        return employeeService.findMinSalary(department);
    }
    @GetMapping("/department-employees")
    public List<Employee> printAllDepartment(@RequestParam("department") int department) {
        return employeeService.printAllDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> printAll() {
        return employeeService.printAll();
    }
}
