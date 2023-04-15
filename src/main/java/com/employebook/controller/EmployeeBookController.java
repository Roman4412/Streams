package com.employebook.controller;

import com.employebook.Employee;
import com.employebook.service.EmployeeService;
import com.employebook.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/departments")
public class EmployeeBookController {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @GetMapping("/max-salary")
    public String findMaxSalary(@RequestParam("department") int department) {
        return employeeService.findMaxSalary(department).toString();
    }
    @GetMapping("/min-salary")
    public String findMinSalary(@RequestParam("department") int department) {
        return employeeService.findMinSalary(department).toString();
    }
    @GetMapping("/department-employees")
    public String printAllDepartment(@RequestParam("department") int department) {
        return employeeService.printAllDepartment(department).toString();
    }
    @GetMapping("/all")
    public String printAll() {
        return employeeService.printAll().toString();

    }

}
