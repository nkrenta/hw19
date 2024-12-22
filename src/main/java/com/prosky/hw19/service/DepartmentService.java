package com.prosky.hw19.service;

import com.prosky.hw19.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalaryByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> getAllEmployeeByDepartment(String department) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
