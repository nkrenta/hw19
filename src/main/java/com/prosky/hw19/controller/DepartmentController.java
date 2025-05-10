package com.prosky.hw19.controller;

import com.prosky.hw19.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prosky.hw19.service.DepartmentService;
import com.prosky.hw19.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping(path="/add-data")
    public void  addTestData(){
        employeeService.addTestData();
        return;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") String departmentId){
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") String departmentId){
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> getAllEmployeeByDepartment(@RequestParam(value = "departmentId", required = false) String departmentId){
        if (departmentId == null) {
            return departmentService.getAllEmployeesByDepartments();
        }
        return departmentService.getAllEmployeeByDepartment(departmentId);
    }
}

